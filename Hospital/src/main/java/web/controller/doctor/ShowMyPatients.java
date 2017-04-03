package web.controller.doctor;

import bean.Doctor;
import bean.Patient;
import bean.User;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;
import service.PatientService;
import service.impl.AttendingDoctorServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.PatientServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.page.Page.CREATE_USER_PAGE;
import static util.page.Page.DOCTORS_PATIENTS_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/ShowMyPatients")
public class ShowMyPatients extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(ShowMyPatients.class);
    private PatientService patientService;
    private AttendingDoctorService attendingDoctorService;
    private DoctorService doctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show patients - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Show patients - clean Error message - start");


        LOG.info("Show my patients - start");
        User user = (User) session.getAttribute("user");
        Doctor doctor = doctorService.getDoctorByUserId(user.getUserId());
        List<Integer> patientIdList = attendingDoctorService.getAllPatientIdByDoctorId(doctor.getDoctorId());

        List<Patient> patientList = new ArrayList<>();
        for (int patientId : patientIdList) {
            patientList.add(patientService.getPatientById(patientId));
        }
        req.setAttribute("patientList", patientList);
        req.getRequestDispatcher(DOCTORS_PATIENTS_PAGE).forward(req, resp);
        LOG.info("Show my patients - end");
    }
}