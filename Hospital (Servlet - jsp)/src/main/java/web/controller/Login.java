package web.controller;

import bean.User;
import org.apache.log4j.Logger;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.UserRequestConverter;
import web.security.AuthenticationManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.LOGIN_PAGE;
import static util.page.Page.MAIN_PAGE;

/**
 * Created by Egor on 07.01.2017.
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String SUCCESSFUL_MESSAGE = "successfulMessage";
    private static final Logger LOG = Logger.getLogger(Login.class);

    AuthenticationManager authenticationManager;
    private HttpRequestConverter<User> requestConverter = new UserRequestConverter();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        authenticationManager = (AuthenticationManager) servletContext.getAttribute("authenticationManager");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        String successfulMessage = (String) session.getAttribute(SUCCESSFUL_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        if (successfulMessage != null) {
            session.removeAttribute(SUCCESSFUL_MESSAGE);
            req.setAttribute(SUCCESSFUL_MESSAGE, successfulMessage);
        }
        LOG.info("Login - clean Error message - start");
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login controller start");
        User userForm = requestConverter.fromRequest(req);

        boolean authentication = authenticationManager.authentication(req, resp, userForm);
        if (authentication) {
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
        } else {
            resp.sendRedirect("Login");
        }
    }
}
