package web.Controller;

import Service.UserService;
import bean.User;
import bean.enams.UserRole;
import org.apache.log4j.Logger;
import util.LoginValidator;
import web.form.LoginForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;

import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.WRONG_INPUT_ERROR;
import static util.page.page.LOGIN_PAGE;
import static util.page.page.MAIN_PAGE;

/**
 * Created by Egor on 07.10.2016.
 */
public class Login extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(Login.class);
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);

        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Login - clean Error message - start");
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login controller start");
        HttpSession session = req.getSession();
        LoginForm loginForm = extractLoginForm(req);

        if (LoginValidator.nonEmptyCheck(loginForm)) {
            errorMessangeToLoginPage(session, resp, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        User user = userService.getUserByEmail(loginForm.getEmail());
        if (user == null) {
            errorMessangeToLoginPage(session, resp, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (user.getPassword().equals(loginForm.getPassword())) {
            session.setAttribute("user", user);

            UserRole role = UserRole.getUserRole(user);
            session.setAttribute("role", role.toString());
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            LOG.info(MessageFormat.format(
                    "User has been logged as: {0} role: {1} Redirect to GET",
                    user.getEmail(), role.toString()));
            return;
        } else {
            errorMessangeToLoginPage(session, resp, WRONG_INPUT_ERROR);
            LOG.error("Wrong input error");
            return;
        }
    }

    private LoginForm extractLoginForm(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        return new LoginForm(email, password);
    }

    private void errorMessangeToLoginPage(HttpSession session, HttpServletResponse resp, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("Login");
    }
}