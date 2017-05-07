package web.security;

import bean.User;
import org.apache.log4j.Logger;
import service.UserService;
import util.validators.LoginValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;

import static util.ErrorMessage.EMPTY_FIELD_ERROR;
import static util.ErrorMessage.USER_NOT_FOUND;

/**
 * Created by Egor on 09.01.2017.
 */
public class AuthenticationManager {

    private static final String ERROR_MESSAGE = "errorMessage";

    private static final Logger LOG = Logger.getLogger(AuthenticationManager.class);

    private UserService userService;

    public AuthenticationManager(UserService userService) {
        this.userService = userService;
    }


    public boolean authentication(HttpServletRequest req, HttpServletResponse resp, User userForm) throws IOException {
        HttpSession session = req.getSession();

        if (LoginValidator.nonEmptyCheck(userForm)) {
            errorMessageToLoginPage(session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return false;
        }

        User userByEmail = userService.getUserByEmail(userForm.getEmail());
        if (userByEmail != null) {
            String securityPassword = SecurityPassword.SecurityPassword(userForm.getPassword());
            String userPassword = userByEmail.getPassword();
            if (securityPassword.equals(userPassword)) {
                session.setAttribute("user", userByEmail);
                session.setAttribute("role", userByEmail.getUserRole().toString());
                LOG.info(MessageFormat.format(
                        "User has been logged as: {0} role: {1} Redirect to GET",
                        userByEmail.getEmail(), userByEmail.getUserRole().toString()));
                return true;
            }
        }
        errorMessageToLoginPage(session, USER_NOT_FOUND);
        LOG.error("User not found");
        return false;
    }

    private void errorMessageToLoginPage(HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
    }
}