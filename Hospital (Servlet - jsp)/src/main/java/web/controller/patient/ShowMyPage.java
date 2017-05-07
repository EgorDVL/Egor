package web.controller.patient;

import bean.HospitalCard;
import bean.Patient;
import bean.User;
import org.apache.log4j.Logger;
import service.HospitalCardService;
import service.PatientService;
import service.UserService;

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
 * Created by Egor on 26.01.2017.
 */
@WebServlet("/ShowMyPage")
public class ShowMyPage extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowMyPage.class);

    private PatientService patientService;
    private HospitalCardService hospitalCardService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show patient's page- start");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Patient patient = patientService.getPatientByUserId(user.getUserId());

        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patient.getPatientId());

        req.setAttribute("patient", patient);
        req.setAttribute("user", user);
        req.setAttribute("hospitalCard", hospitalCard);

        req.getRequestDispatcher(SHOW_PATIENT_PAGE).forward(req, resp);
        LOG.info("Show patient's page- end");
    }
}
