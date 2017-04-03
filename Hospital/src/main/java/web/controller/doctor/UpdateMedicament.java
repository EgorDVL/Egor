package web.controller.doctor;

import bean.Medicament;
import org.apache.log4j.Logger;
import service.MedicamentService;
import service.impl.MedicamentServiceImpl;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.MedicamentRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.UPDATE_MEDICAMENT_PAGE;

/**
 * Created by Egor on 18.01.2017.
 */
@WebServlet("/UpdateMedicament")
public class UpdateMedicament extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateMedicament.class);
    private MedicamentService medicamentService;
    private HttpRequestConverter<Medicament> requestConverter = new MedicamentRequestConverter();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        medicamentService = (MedicamentService) servletContext.getAttribute("medicamentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get medicamentId for update - start");
        HttpSession session = req.getSession();
        int medicamentId = Integer.parseInt(req.getParameter("medicamentId"));
        Medicament medicament = medicamentService.getMedicamentById(medicamentId);

        req.setAttribute("medicament", medicament);

        LOG.info("Get medicamentId for update - end");
        req.getRequestDispatcher(UPDATE_MEDICAMENT_PAGE).forward(req, resp);

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update medicaments - start");
        HttpSession session = req.getSession();

        Medicament medicament = requestConverter.fromRequest(req);
        medicamentService.updateMedicament(medicament);

        LOG.info("Update medicaments - end");

        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}
