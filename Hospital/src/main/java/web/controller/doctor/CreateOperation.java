package web.controller.doctor;

import static util.ErrorMessage.*;

import bean.Operation;
import org.apache.log4j.Logger;
import service.OperationService;
import service.impl.OperationsServiceImpl;
import util.validators.CreateOperationValidator;
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

import static util.page.Page.CREATE_APPOINTMENT_PAGE;
import static util.page.Page.CREATE_OPERATION_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateOperation")
public class CreateOperation extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateOperation.class);
    private static final String ERROR_MESSAGE = "errorMessage";

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
        LOG.info("Create Operation - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create Operation - clean Error message - start");
        req.getRequestDispatcher(CREATE_OPERATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show my patients - start");
        HttpSession session = req.getSession();

        Operation operationForm = requestConverter.fromRequest(req);

        if (CreateOperationValidator.nonEmpty(operationForm)) {
            errorMessageToCreateOperation(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreateOperationValidator.validateDate(operationForm.getDateOperation())) {
            errorMessageToCreateOperation(resp, session, INCORRECT_DATE_OPERATION);
            LOG.error("Incorrect date operation");
            return;
        }

        int operationId = operationService.createOperation(operationForm);

        LOG.info("Show operation - start");

        if (String.valueOf(operationId) != null) {
            Operation operation = operationService.getOperationById(operationId);
            session.setAttribute("operation", operation);
        }
        session.setAttribute("operationId", String.valueOf(operationId));

        LOG.info("Show operation - end");
        LOG.info("Show my patients - end");
        req.getRequestDispatcher(CREATE_APPOINTMENT_PAGE).forward(req, resp);
    }

    private void errorMessageToCreateOperation(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateOperation");
    }
}
