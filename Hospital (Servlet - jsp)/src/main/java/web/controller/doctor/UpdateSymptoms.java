package web.controller.doctor;

import static util.page.Page.*;

import bean.Healing;
import org.apache.log4j.Logger;
import service.HealingService;

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
 * Created by Egor on 25.01.2017.
 */
@WebServlet("/UpdateSymptoms")
public class UpdateSymptoms extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateSymptoms.class);
    private HealingService healingService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        healingService = (HealingService) servletContext.getAttribute("healingService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get healingId for update symptoms - start");
        HttpSession session = req.getSession();

        Healing healing = healingService.getHealingById(Integer.parseInt(req.getParameter("healingId")));
        req.setAttribute("healing", healing);

        req.getRequestDispatcher(UPDATE_SYMPTOMS_PAGE).forward(req, resp);
        LOG.info("Get healingId for update symptoms - end");

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update symptoms - start");
        HttpSession session = req.getSession();

        int healingId = Integer.parseInt(req.getParameter("healingId"));
        String symptoms = req.getParameter("symptoms");

        Healing healing = healingService.getHealingById(healingId);

        healingService.updateHealing(new Healing(healingId, symptoms, healing.getDateHealingStart(),
                healing.getDateHealingEnd(), healing.getAppointmentId(),
                healing.getDiagnosisId(), healing.getHospitalCardId()));

        LOG.info("Update symptoms - end");

        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}
