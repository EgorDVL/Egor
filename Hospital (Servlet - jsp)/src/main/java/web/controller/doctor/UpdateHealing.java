package web.controller.doctor;

import bean.Healing;
import org.apache.log4j.Logger;
import service.HealingService;
import service.impl.HealingServiceImpl;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.HealingRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

import static util.page.Page.UPDATE_HEALING_PAGE;

/**
 * Created by Egor on 19.01.2017.
 */
@WebServlet("/UpdateHealing")
public class UpdateHealing extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateMedicament.class);
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
    private HealingService healingService;
    private HttpRequestConverter<Healing> requestConverter = new HealingRequestConverter();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        healingService = (HealingService) servletContext.getAttribute("healingService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get healingId for update - start");
        HttpSession session = req.getSession();
        int healingId = Integer.parseInt(req.getParameter("healingId"));
        Healing healing = healingService.getHealingById(healingId);
        req.setAttribute("healing", healing);

        LOG.info("Get healingId for update - end");
        req.getRequestDispatcher(UPDATE_HEALING_PAGE).forward(req, resp);

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update healing - start");
        HttpSession session = req.getSession();
        int healingId = Integer.parseInt(req.getParameter("healingId"));
        String symptoms = req.getParameter("symptoms");
        Date dateStart = dateUtils.parse(req.getParameter("dateStart"));
        Date dateEnd = dateUtils.parse(req.getParameter("dateEnd"));
        int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
        int diagnosisId = Integer.parseInt(req.getParameter("diagnosisId"));
        int hospitalCardId = Integer.parseInt(req.getParameter("hospitalCardId"));

        Healing healing = new Healing(healingId, symptoms, dateStart, dateEnd, appointmentId, diagnosisId, hospitalCardId);

        healingService.updateHealing(healing);
        LOG.info("Update healing - end");
        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}
