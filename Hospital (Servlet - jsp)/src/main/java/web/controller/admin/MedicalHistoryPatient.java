package web.controller.admin;

import bean.Healing;
import org.apache.log4j.Logger;
import service.HealingService;
import service.impl.HealingServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.Page.MEDICAL_HISTORY_PATIENT_PAGE;

/**
 * Created by Egor on 12.01.2017.
 */
@WebServlet("/MedicalHistoryPatient")
public class MedicalHistoryPatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(MedicalHistoryPatient.class);
    private HealingService healingService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        healingService = (HealingService) servletContext.getAttribute("healingService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all healing - start");
        int hospitalCardId = Integer.parseInt(req.getParameter("hospitalCardId"));

        List<Healing> healingList = healingService.getAllHealingByHospitalCard(hospitalCardId);

        req.setAttribute("healingList", healingList);
        req.getRequestDispatcher(MEDICAL_HISTORY_PATIENT_PAGE).forward(req, resp);
        LOG.info("Show all healing - end");
    }
}
