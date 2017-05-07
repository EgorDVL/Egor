package web.controller.admin;

import static util.page.Page.*;

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

/**
 * Created by Egor on 15.01.2017.
 */
@WebServlet("/SortPatient")
public class SortPatient extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(SortPatient.class);
    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Sort for all patient - start");
        HttpSession session = req.getSession();
        String sortParam = req.getParameter("sort");
        List<Patient> patientList = patientService.sortPatientByParam(sortParam);

        req.setAttribute("patientList", patientList);

        session.setAttribute("sortParam", sortParam);
        req.getRequestDispatcher(SHOW_ALL_PATIENTS_PAGE).forward(req, resp);
        LOG.info("Sort for all patient - end");
    }
}
