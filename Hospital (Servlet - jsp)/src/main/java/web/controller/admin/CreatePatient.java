package web.controller.admin;

import bean.Patient;
import org.apache.log4j.Logger;
import service.HospitalCardService;
import service.PatientService;
import service.impl.HospitalCardServiceImpl;
import service.impl.PatientServiceImpl;
import util.validators.CreateNurseValidator;
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

import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.ILLEGAL_CHARACTER_ERROR;
import static util.ErrorMessage.INCORRECT_DATE_OF_BIRTH;
import static util.page.Page.*;

/**
 * Created by Egor on 11.01.2017.
 */
@WebServlet("/CreatePatient")
public class CreatePatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreatePatient.class);
    private HttpRequestConverter<Patient> requestConverter = new PatientRequestConverter();
    private static final String ERROR_MESSAGE = "errorMessage";

    private PatientService patientService;
    private HospitalCardService hospitalCardService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create patient - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create patient - clean Error message - start");
        req.getRequestDispatcher(CREATE_PATIENT_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create Patient - start");
        HttpSession session = req.getSession();
        Patient patient = requestConverter.fromRequest(req);

        if (CreatePatientValidator.nonEmpty(patient)) {
            errorMessageToCreatePatient(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreatePatientValidator.validateDate(patient.getDateOfBirth())) {
            errorMessageToCreatePatient(resp, session, INCORRECT_DATE_OF_BIRTH);
            LOG.error("Incorrect date of birth");
            return;
        }
        if (!CreatePatientValidator.validateForm(patient)) {
            errorMessageToCreatePatient(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }

        int patientId = patientService.createPatient(patient);

        hospitalCardService.createHospitalCard(patientId);

        resp.sendRedirect("ShowAllPatient");
        LOG.info("Create Patient - end");
    }


    private void errorMessageToCreatePatient(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreatePatient");
    }
}
