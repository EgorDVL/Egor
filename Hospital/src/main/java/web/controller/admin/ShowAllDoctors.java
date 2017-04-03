package web.controller.admin;

import static util.page.Page.*;

import bean.AttendingDoctor;
import bean.Doctor;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

import javax.print.Doc;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Egor on 09.01.2017.
 */
@WebServlet("/ShowAllDoctors")
public class ShowAllDoctors extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ShowAllDoctors.class);
    private DoctorService doctorService;
    private AttendingDoctorService attendingDoctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all doctors - start");
        Map<Doctor, Integer> doctorMap = new HashedMap();

        for (Doctor doctor : doctorService.getAllDoctors()) {
            List<Integer> count = attendingDoctorService.getAllPatientIdByDoctorId(doctor.getDoctorId());
            doctorMap.put(doctor, count.size());
        }

        req.setAttribute("doctorList", doctorMap);
        req.getRequestDispatcher(SHOW_ALL_DOCTORS_PAGE).forward(req, resp);
        LOG.info("Show all doctors - end");
    }
}
