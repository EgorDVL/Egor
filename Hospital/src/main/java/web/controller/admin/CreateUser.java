package web.controller.admin;

import static util.page.Page.*;

import bean.User;
import bean.enums.UserRole;
import org.apache.log4j.Logger;
import service.UserService;
import util.validators.RegistrationValidator;
import web.security.EmailSending;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.UserRequestConverter;

import javax.mail.MessagingException;
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

/**
 * Created by Egor on 10.01.2017.
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String SUCCESSFUL_MESSAGE = "successfulMessage";
    private static final Logger LOG = Logger.getLogger(CreateUser.class);

    private UserService userService;
    private HttpRequestConverter<User> requestConverter = new UserRequestConverter();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Registration - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Registration - clean Error message - start");
        req.getRequestDispatcher(CREATE_USER_PAGE).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Registration - start");

        User userForm = requestConverter.fromRequest(req);

        HttpSession session = req.getSession();

        if (RegistrationValidator.nonEmptyCheck(userForm)) {
            errorMessageToRegistrationForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }

        if (!RegistrationValidator.validateForm(userForm)) {
            errorMessageToRegistrationForm(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }

        User user = userService.getUserByEmail(userForm.getEmail());
        if (user != null) {
            errorMessageToRegistrationForm(resp, session, USER_ALREADY_EXISTS);
            LOG.error("User already exists");
            return;
        }

        int userId = userService.createUser(userForm.getEmail(), userForm.getPassword(), userForm.getUserRole());

        session.setAttribute("userId", userId);
        
//        try {
//            EmailSending.sendMailMessange(userForm.getEmail(), userForm.getPassword());
//        } catch (MessagingException e) {
//            LOG.error("Can't send message to this mail: " + userForm.getEmail(), e);
//        }

        requestToUserByRole(req, resp, userForm);
        LOG.info("Registration - end");
    }

    private void requestToUserByRole(HttpServletRequest req, HttpServletResponse resp, User userForm) throws ServletException, IOException {
        if (userForm.getUserRole().equals(UserRole.DOCTOR)) {
            req.getRequestDispatcher(CREATE_DOCTOR_PAGE).forward(req, resp);
        }
        if (userForm.getUserRole().equals(UserRole.NURSE)) {
            req.getRequestDispatcher(CREATE_NURSE_PAGE).forward(req, resp);
        }
        if (userForm.getUserRole().equals(UserRole.PATIENT)) {
            req.getRequestDispatcher(CREATE_PATIENT_PAGE).forward(req, resp);
        }
    }

    private void errorMessageToRegistrationForm(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateUser");
    }

    private void successfulMessageToRegistrationForm(HttpServletResponse resp, HttpSession session, String successfulMessage) throws IOException {
        session.setAttribute(SUCCESSFUL_MESSAGE, successfulMessage);
        resp.sendRedirect(MAIN_PAGE);
    }
}