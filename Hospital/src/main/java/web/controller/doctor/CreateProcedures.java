package web.controller.doctor;

import static util.ErrorMessage.*;

import bean.Procedures;
import org.apache.log4j.Logger;
import service.ProceduresService;
import service.impl.ProceduresServiceImpl;
import util.validators.CreateProcedureValidator;
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

import static util.page.Page.CREATE_APPOINTMENT_PAGE;
import static util.page.Page.CREATE_PROCEDURES_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateProcedures")
public class CreateProcedures extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateProcedures.class);
    private static final String ERROR_MESSAGE = "errorMessage";

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
        LOG.info("Create Procedures - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create Procedures - clean Error message - start");
        req.getRequestDispatcher(CREATE_PROCEDURES_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create medicament - start");
        HttpSession session = req.getSession();
        Procedures proceduresForm = requestConverter.fromRequest(req);

        if (CreateProcedureValidator.nonEmpty(proceduresForm)) {
            errorMessageToCreateProcedure(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreateProcedureValidator.validateDate(proceduresForm.getDateStartProcedure(), proceduresForm.getDateEndProcedure())) {
            errorMessageToCreateProcedure(resp, session, INCORRECT_DATE_PROCEDURES);
            LOG.error("Incorrect date procedures");
            return;
        }

        int proceduresId = proceduresService.createProcedures(proceduresForm);

        LOG.info("Show Procedures - start");
        if (String.valueOf(proceduresId) != null) {
            Procedures procedures = proceduresService.getProceduresById(proceduresId);
            session.setAttribute("procedures", procedures);
        }
        LOG.info("Show Procedures - end");

        session.setAttribute("proceduresId", String.valueOf(proceduresId));
        req.getRequestDispatcher(CREATE_APPOINTMENT_PAGE).forward(req, resp);
        LOG.info("Create medicament - end");
    }

    private void errorMessageToCreateProcedure(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateProcedures");
    }
}
