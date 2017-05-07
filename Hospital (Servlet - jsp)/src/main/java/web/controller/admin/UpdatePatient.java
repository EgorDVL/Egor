package web.controller.admin;

import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.ILLEGAL_CHARACTER_ERROR;
import static util.ErrorMessage.INCORRECT_DATE_OF_BIRTH;
import static util.page.Page.*;

import bean.Patient;
import org.apache.log4j.Logger;
import service.PatientService;
import util.validators.CreatePatientValidator;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.PatientRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 02.02.2017.
 */
@WebServlet("/UpdatePatient")
public class UpdatePatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllPatients.class);
    private PatientService patientService;
    private HttpRequestConverter<Patient> requestConverter = new PatientRequestConverter();

    private static final String ERROR_MESSAGE = "errorMessage";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get patientId for update - start");
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        Patient patient = patientService.getPatientById(patientId);

        req.setAttribute("patient", patient);

        LOG.info("Get patientId for update - end");

        req.getRequestDispatcher(UPDATE_PATIENT_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update patient - start");
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        patientService.updatePatient(patientId, name, surname, phone, address);
        LOG.info("Update patient - end");
        resp.sendRedirect("ShowAllPatient");
    }
}

