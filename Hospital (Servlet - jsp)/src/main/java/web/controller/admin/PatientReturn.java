package web.controller.admin;

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
import java.io.IOException;

/**
 * Created by Egor on 13.01.2017.
 */
@WebServlet("/PatientReturn")
public class PatientReturn extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(PatientReturn.class);
    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Patient returned, change status - start");
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        patientService.updatePatientStatus(patientId, PatientStatus.NOT_TREATED);

        resp.sendRedirect("ShowAllPatient");

        LOG.info("Patient returned, change status - end");
    }
}
