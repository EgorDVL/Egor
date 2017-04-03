package web.controller.doctor;

import static util.ErrorMessage.*;

import org.apache.log4j.Logger;
import service.ProceduresService;

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
 * Created by Egor on 20.01.2017.
 */
@WebServlet("/ExecuteProcedure")
public class ExecuteProcedure extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ExecuteProcedure.class);
    private static final String ERROR_MESSAGE = "errorMessage";
    private ProceduresService proceduresService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        proceduresService = (ProceduresService) servletContext.getAttribute("proceduresService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Execute Procedures - start");
        int procedureId = Integer.parseInt(req.getParameter("procedureId"));

        if (!proceduresService.executeProcedures(procedureId)) {
            errorMessageToExecuteProcedure(req, EXECUTE_PROCEDURES);
        }
        resp.sendRedirect("PatientHealing?healingId=" + req.getParameter("healingId"));
        LOG.info("Execute Procedures - end");
    }

    private void errorMessageToExecuteProcedure(HttpServletRequest req, String errorMessage) throws IOException {
        req.getSession().setAttribute(ERROR_MESSAGE, errorMessage);
    }
}
