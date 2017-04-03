package web.controller.admin;

import bean.Patient;
import bean.enums.PatientStatus;
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

import static util.page.Page.SHOW_ALL_PATIENTS_PAGE;

/**
 * Created by Egor on 14.01.2017.
 */
@WebServlet("/GroupPatientByStatus")
public class GroupPatientByStatus extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(GroupPatientByStatus.class);
    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all patients by status - start");
        HttpSession session = req.getSession();

        String patientStatus = req.getParameter("status");
        List<Patient> patientList;

        if (patientStatus.toString().equalsIgnoreCase("ALL")) {
            patientList = patientService.getAllPatients();
            req.setAttribute("patientList", patientList);
            session.setAttribute("status", patientStatus);
        } else {
            patientList = patientService.getAllPatientsByStatus(PatientStatus.getValue(patientStatus));
            req.setAttribute("patientList", patientList);
            session.setAttribute("status", patientStatus);
        }
        req.getRequestDispatcher(SHOW_ALL_PATIENTS_PAGE).forward(req, resp);
        LOG.info("Show all patients by status - end");
    }
}
