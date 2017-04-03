package web.controller.doctor;

import org.apache.log4j.Logger;
import service.OperationService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.EXECUTE_OPERATION;
import static util.page.Page.LOGIN_PAGE;

/**
 * Created by Egor on 20.01.2017.
 */
@WebServlet("/ExecuteOperation")
public class ExecuteOperation extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ExecuteOperation.class);
    private static final String ERROR_MESSAGE = "errorMessage";
    private OperationService operationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        operationService = (OperationService) servletContext.getAttribute("operationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Execute Operation - start");

        int operationId = Integer.parseInt(req.getParameter("operationId"));
        if (!operationService.executeOperation(operationId)) {
            errorMessageToExecuteOperation(req, EXECUTE_OPERATION);
        }
        resp.sendRedirect("PatientHealing?healingId=" + req.getParameter("healingId"));
        LOG.info("Execute Operation - end");
    }

    private void errorMessageToExecuteOperation(HttpServletRequest req, String errorMessage) throws IOException {
        req.getSession().setAttribute(ERROR_MESSAGE, errorMessage);
    }
}
