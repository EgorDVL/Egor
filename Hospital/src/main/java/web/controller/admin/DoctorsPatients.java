package web.controller.admin;

import bean.Patient;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.PatientService;
import service.impl.AttendingDoctorServiceImpl;
import service.impl.PatientServiceImpl;

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

import static util.page.Page.DOCTORS_PATIENTS_PAGE;

/**
 * Created by Egor on 14.01.2017.
 */
@WebServlet("/DoctorsPatients")
public class DoctorsPatients extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(DoctorsPatients.class);

    private PatientService patientService;
    private AttendingDoctorService attendingDoctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show doctor's patient - start");
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        List<Integer> patientIdList = attendingDoctorService.getAllPatientIdByDoctorId(doctorId);

        List<Patient> patientList = new ArrayList<>();
        for (int patientId : patientIdList) {
            patientList.add(patientService.getPatientById(patientId));
        }
        req.setAttribute("patientList", patientList);
        req.getRequestDispatcher(DOCTORS_PATIENTS_PAGE).forward(req, resp);
        LOG.info("Show doctor's patient - end");
    }
}