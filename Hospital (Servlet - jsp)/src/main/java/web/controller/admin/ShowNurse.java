package web.controller.admin;

import bean.Department;
import bean.Nurse;
import bean.User;
import org.apache.log4j.Logger;
import service.DepartmentService;
import service.NurseService;
import service.UserService;
import service.impl.DepartmentServiceImpl;
import service.impl.NurseServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static util.page.Page.SHOW_NURSE_PAGE;

/**
 * Created by Egor on 11.01.2017.
 */
@WebServlet("/ShowNurse")
public class ShowNurse extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowNurse.class);

    private NurseService nurseService;
    private UserService userService;
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
        departmentService = (DepartmentService) servletContext.getAttribute("departmentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show nurse - start");
        HttpSession session = req.getSession();

        int nurseId = Integer.parseInt(req.getParameter("nurseId"));
        Nurse nurse = nurseService.getNurseById(nurseId);
        User user = userService.getUserById(nurse.getUserId());
        List<Department> departments = departmentService.getAllDepartment();

        req.setAttribute("nurse", nurse);
        req.setAttribute("user", user);
        req.setAttribute("departments", departments);

        req.getRequestDispatcher(SHOW_NURSE_PAGE).forward(req, resp);

        session.setAttribute("previousPageNurse", req.getHeader("referer"));
        LOG.info("Show nurse - end");
    }
}
