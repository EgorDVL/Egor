package web.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 21.01.2017.
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(Logout.class);

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LOG.info("Logout command - start");
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            LOG.info("Session has been invalidated");
        }
        resp.sendRedirect("Login");
        LOG.info("Logout command - end");
        return;
    }
}
