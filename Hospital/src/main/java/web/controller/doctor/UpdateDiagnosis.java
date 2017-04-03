package web.controller.doctor;

import bean.Diagnosis;
import org.apache.log4j.Logger;
import service.DiagnosisService;
import service.impl.DiagnosisServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.UPDATE_DIAGNOSIS_PAGE;

/**
 * Created by Egor on 18.01.2017.
 */
@WebServlet("/UpdateDiagnosis")
public class UpdateDiagnosis extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateDiagnosis.class);
    private DiagnosisService diagnosisService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        diagnosisService = (DiagnosisService) servletContext.getAttribute("diagnosisService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get diagnosisId for update - start");
        HttpSession session = req.getSession();

        int diagnosisId = Integer.parseInt(req.getParameter("diagnosisId"));
        Diagnosis diagnosis = diagnosisService.getDiagnosisById(diagnosisId);

        req.setAttribute("diagnosis", diagnosis);

        LOG.info("Get diagnosisId for update - end");
        req.getRequestDispatcher(UPDATE_DIAGNOSIS_PAGE).forward(req, resp);

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update diagnosis - start");
        HttpSession session = req.getSession();
        int diagnosisId = Integer.parseInt(req.getParameter("diagnosisId"));
        String diagnosisName = req.getParameter("diagnosis");
        Diagnosis diagnosis = new Diagnosis(diagnosisId, diagnosisName);
        
        diagnosisService.updateDiagnosis(diagnosis);

        LOG.info("Update diagnosis - end");

        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}
