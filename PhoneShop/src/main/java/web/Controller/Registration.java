package web.Controller;

import static util.ErrorMessage.*;

import Service.UserService;
import org.apache.log4j.Logger;
import util.RegistrationValidator;
import web.form.RegistrationForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.page.LOGIN_PAGE;
import static util.page.page.REGISTRATION_PAGE;

/**
 * Created by Egor on 09.10.2016.
 */
public class Registration extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(Registration.class);
    private UserService userService = new UserService();

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
        req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Registration - start");
        HttpSession session = req.getSession();
        RegistrationForm registrationForm = extractRegistrationForm(req);

        if (RegistrationValidator.nonEmptyCheckRegistration(registrationForm)) {
            errorMessageToRegistrationForm(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (!RegistrationValidator.validateForm(registrationForm)) {
            errorMessageToRegistrationForm(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }
        boolean result = userService.createUser(registrationForm.getEmail(), registrationForm.getPassword(),
                registrationForm.getName(), registrationForm.getSurname(), registrationForm.getPhone(),
                registrationForm.getRoleId());
        if (!result) {
            errorMessageToRegistrationForm(resp, session, USER_ALREADY_EXISTS);
            LOG.error("User already exists");
            return;
        }
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        LOG.info("Registration - end");
    }

    private RegistrationForm extractRegistrationForm(HttpServletRequest req) throws NumberFormatException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        return new RegistrationForm(email, password, name, surname, phone, roleId);
    }

    private void errorMessageToRegistrationForm(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("Registration");
    }
}