package web.controller.doctor;

import bean.Operation;
import org.apache.log4j.Logger;
import service.OperationService;
import service.impl.OperationsServiceImpl;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.OperationRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.*;

/**
 * Created by Egor on 17.01.2017.
 */
@WebServlet("/UpdateOperation")
public class UpdateOperation extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateOperation.class);
    private OperationService operationService;
    private HttpRequestConverter<Operation> requestConverter = new OperationRequestConverter();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        operationService = (OperationService) servletContext.getAttribute("operationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get operationId for update - start");
        HttpSession session = req.getSession();
        int operationId = Integer.parseInt(req.getParameter("operationId"));
        Operation operation = operationService.getOperationById(operationId);

        req.setAttribute("operation", operation);

        LOG.info("Get operationId for update - end");
        req.getRequestDispatcher(UPDATE_OPERATION_PAGE).forward(req, resp);

        String previousPage = req.getHeader("referer");// to came back in here page
        session.setAttribute("previousPage", previousPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show my patients - start");
        HttpSession session = req.getSession();
        Operation operation = requestConverter.fromRequest(req);
        operationService.updateOperation(operation);

        LOG.info("Show my patients - end");
        String previousPage = (String) session.getAttribute("previousPage");
        resp.sendRedirect(previousPage);
        session.removeAttribute("previousPage");
    }
}