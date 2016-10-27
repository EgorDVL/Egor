package web.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }
}
