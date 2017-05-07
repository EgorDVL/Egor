package web.controller.admin;

import bean.Nurse;
import org.apache.log4j.Logger;
import service.NurseService;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Egor on 26.01.2017.
 */
@WebServlet("/DeleteNurse")
public class DeleteNurse extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(DeleteNurse.class);
    private NurseService nurseService;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
        userService = (UserService) servletContext.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Delete nurse by id - start");
        int nurseId = Integer.parseInt(req.getParameter("nurseId"));

        Nurse nurse = nurseService.getNurseById(nurseId);
        int nurseUserId = nurse.getUserId();

        nurseService.deleteNurseById(nurseId);
        userService.deleteUserById(nurseUserId);
        resp.sendRedirect("ShowAllNurses");
        LOG.info("Delete nurse by id - end");
    }
}
