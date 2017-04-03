package web.controller.admin;

import static util.ErrorMessage.*;
import static util.page.Page.*;

import bean.Patient;
import org.apache.log4j.Logger;
import service.PatientService;
import util.DateUtils;

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
import java.util.Date;
import java.util.List;

/**
 * Created by Egor on 23.01.2017.
 */
@WebServlet("/FindPatientByParam")
public class FindPatientByParam extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(FindPatientByParam.class);
    private static final String ERROR_MESSAGE = "errorMessage";

    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Find patients by param  - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Find patients by param - clean Error message - start");
        req.getRequestDispatcher(SEARCH_PATIENT_BY_PARAMS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Find all patient by param - start");
        HttpSession session = req.getSession();
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String dateOfBirth = req.getParameter("dateOfBirth");

        if (!(surname.isEmpty() && phone.isEmpty() && dateOfBirth.isEmpty())) {
            List<Patient> patientList = patientService.findPatientByParam(surname, phone, dateOfBirth);
            req.setAttribute("patientList", patientList);
            req.getRequestDispatcher(SHOW_ALL_PATIENTS_PAGE).forward(req, resp);
        } else {
            errorMessageToSearchPage(session, EMPTY_FIELD_ERROR, resp);
        }
        LOG.info("Find all patient by param - end");
    }

    private void errorMessageToSearchPage(HttpSession session, String errorMessage, HttpServletResponse resp) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("FindPatientByParam");
    }
}
