package web.controller.doctor;

import bean.Procedures;
import org.apache.log4j.Logger;
import service.ProceduresService;
import service.impl.ProceduresServiceImpl;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.ProceduresRequestCanverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.UPDATE_PROCEDURES_PAGE;

/**
 * Created by Egor on 18.01.2017.
 */
@WebServlet("/UpdateProcedures")
public class UpdateProcedures extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateProcedures.class);
    private ProceduresService proceduresService;
    private HttpRequestConverter<Procedures> requestConverter = new ProceduresRequestCanverter();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        proceduresService = (ProceduresService) servletContext.getAttribute("proceduresService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get proceduresId for update - start");
        HttpSession session = req.getSession();
        int proceduresId = Integer.parseInt(req.getParameter("proceduresId"));
        Procedures procedures = proceduresService.getProceduresById(proceduresId);

        req.setAttribute("procedures", procedures);

        LOG.info("Get proceduresId for update - end");
        req.getRequestDispatcher(UPDATE_PROCEDURES_PAGE).forward(req, resp);

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update procedures - start");
        HttpSession session = req.getSession();
        Procedures procedures = requestConverter.fromRequest(req);
        proceduresService.updateProcedures(procedures);
        LOG.info("Update procedures - end");
        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}
