package web.controller.admin;

import bean.Nurse;
import org.apache.log4j.Logger;
import service.NurseService;
import util.validators.CreateNurseValidator;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.NurseRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.*;
import static util.page.Page.CREATE_NURSE_PAGE;

/**
 * Created by Egor on 11.01.2017.
 */
@WebServlet("/CreateNurse")
public class CreateNurse extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CreateNurse.class);
    private HttpRequestConverter<Nurse> requestConverter = new NurseRequestConverter();
    private NurseService nurseService;
    private static final String ERROR_MESSAGE = "errorMessage";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create doctor - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create doctor - clean Error message - start");
        req.getRequestDispatcher(CREATE_NURSE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create Nurse - start");
        HttpSession session = req.getSession();
        Nurse nurse = requestConverter.fromRequest(req);

        if (CreateNurseValidator.nonEmpty(nurse)) {
            errorMessageToCreateNurse(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreateNurseValidator.validateDate(nurse.getDateOfBirth())) {
            errorMessageToCreateNurse(resp, session, INCORRECT_DATE_OF_BIRTH);
            LOG.error("Incorrect date of birth");
            return;
        }
        if (!CreateNurseValidator.validateForm(nurse)) {
            errorMessageToCreateNurse(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }
        nurseService.createNurse(nurse);

        resp.sendRedirect("ShowAllNurses");
        LOG.info("Create Nurse - end");
    }

    private void errorMessageToCreateNurse(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateNurse");
    }
}
