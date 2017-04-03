package web.controller.doctor;

import bean.Healing;
import bean.HospitalCard;
import org.apache.log4j.Logger;
import service.HealingService;
import service.HospitalCardService;
import service.impl.HealingServiceImpl;
import service.impl.HospitalCardServiceImpl;
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

import static util.page.Page.MAIN_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateHealing")
public class CreateHealing extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateHealing.class);

    private HttpRequestConverter<Healing> requestConverter = new HealingRequestConverter();

    private HealingService healingService;
    private HospitalCardService hospitalCardService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        healingService = (HealingService) servletContext.getAttribute("healingService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create healing - start");
        HttpSession session = req.getSession();

        int patientId = (int) session.getAttribute("patientIdForHealing");//from showPatient

        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patientId);

        session.setAttribute("hospitalCardIdForHealing", hospitalCard.getHospitalCardId()); // to healingRequestConverter

        Healing healing = requestConverter.fromRequest(req);
        healingService.createHealing(healing);

        resp.sendRedirect("ShowMyPatients");
        LOG.info("Create healing - end");
    }
}
