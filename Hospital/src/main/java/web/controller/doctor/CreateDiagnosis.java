package web.controller.doctor;

import org.apache.log4j.Logger;
import service.DiagnosisService;
import util.validators.CreateDiagnosisValidator;

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
import static util.page.Page.CREATE_APPOINTMENT_PAGE;
import static util.page.Page.CREATE_DIAGNOSIS_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateDiagnosis")
public class CreateDiagnosis extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(CreateDiagnosis.class);
    private DiagnosisService diagnosisService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        diagnosisService = (DiagnosisService) servletContext.getAttribute("diagnosisService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create Diagnosis - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create Diagnosis - clean Error message - start");
        req.getRequestDispatcher(CREATE_DIAGNOSIS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create new diagnosis - start");

        HttpSession session = req.getSession();
        String symptoms = req.getParameter("symptoms"); // to healingRequestConverter
        String diagnosis = req.getParameter("diagnosis");

        if (CreateDiagnosisValidator.nonEmptyCheck(diagnosis, symptoms)) {
            errorMessageToCreateDiagnosis(resp, session, EMPTY_FIELD_ERROR);
            return;
        } else {
            int diagnosisId = diagnosisService.createDiagnosis(diagnosis);
            session.setAttribute("diagnosisId", diagnosisId);
            session.setAttribute("symptoms", symptoms);

            req.getRequestDispatcher(CREATE_APPOINTMENT_PAGE).forward(req, resp);
            LOG.info("Create new diagnosis - end");
        }
    }

    private void errorMessageToCreateDiagnosis(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateDiagnosis");
    }
}
