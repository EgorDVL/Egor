package web.controller.admin;

import bean.HospitalCard;
import bean.Patient;
import bean.User;
import org.apache.log4j.Logger;
import service.HospitalCardService;
import service.PatientService;
import service.UserService;
import service.impl.HospitalCardServiceImpl;
import service.impl.PatientServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.SHOW_PATIENT_PAGE;

/**
 * Created by Egor on 10.01.2017.
 */
@WebServlet("/ShowPatient")
public class ShowPatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowPatient.class);

    private PatientService patientService;
    private UserService userService;
    private HospitalCardService hospitalCardService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        patientService = (PatientService) servletContext.getAttribute("patientService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show patient - start");
        HttpSession session = req.getSession();
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        Patient patient = patientService.getPatientById(patientId);
        User user = userService.getUserById(patient.getUserId());
        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patientId);

        req.setAttribute("patient", patient);
        req.setAttribute("user", user);
        req.setAttribute("hospitalCard", hospitalCard);

        session.setAttribute("patientIdForHealing", patient.getPatientId()); // for create new healing

        req.getRequestDispatcher(SHOW_PATIENT_PAGE).forward(req, resp);
        LOG.info("Show patient - end");
    }
}
