package web.controller.admin;

import bean.Patient;
import org.apache.log4j.Logger;
import service.PatientService;
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
import java.util.List;

import static util.page.Page.SEARCH_PATIENT_BY_PARAMS_PAGE;
import static util.page.Page.SHOW_ALL_PATIENTS_PAGE;

/**
 * Created by Egor on 10.01.2017.
 */
@WebServlet("/ShowAllPatient")
public class ShowAllPatients extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllPatients.class);
    private PatientService patientService;
    private static final String ERROR_MESSAGE = "errorMessage";

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


        LOG.info("Show all patients - start");
        List<Patient> patientList = patientService.getAllPatients();
        req.setAttribute("patientList", patientList);
        req.getRequestDispatcher(SHOW_ALL_PATIENTS_PAGE).forward(req, resp);
        LOG.info("Show all patients - end");
    }
}
