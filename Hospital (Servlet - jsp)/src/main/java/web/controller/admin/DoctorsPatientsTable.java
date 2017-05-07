package web.controller.admin;

import bean.Doctor;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Egor on 03.02.2017.
 */
@WebServlet("/DoctorsPatientsTable")
public class DoctorsPatientsTable extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DoctorsPatientsTable.class);
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
        LOG.info("Show all doctors and count patients - start");

        Map<Doctor, Integer> doctorMap = new HashMap<>();

        for (Doctor doctor : doctorService.getAllDoctors()) {
            List<Integer> count = attendingDoctorService.getAllPatientIdByDoctorId(doctor.getDoctorId());
            doctorMap.put(doctor, count.size());
        }
        req.setAttribute("doctorMap", sortByValue(doctorMap));

        req.getRequestDispatcher("adminPages/count-patient.jsp").forward(req, resp);
        LOG.info("Show all doctors and count patients - end");
    }

    public static <Doctor, Integer extends Comparable<? super Integer>> Map<Doctor, Integer>
    sortByValue(Map<Doctor, Integer> map) {

        List<Map.Entry<Doctor, Integer>> list = new LinkedList<Map.Entry<Doctor, Integer>>(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<Doctor, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Doctor, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
