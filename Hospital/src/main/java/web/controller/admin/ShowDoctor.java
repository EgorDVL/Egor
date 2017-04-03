package web.controller.admin;

import static util.page.Page.*;

import bean.Department;
import bean.Doctor;
import bean.User;
import org.apache.log4j.Logger;
import service.DepartmentService;
import service.DoctorService;
import service.UserService;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
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

/**
 * Created by Egor on 09.01.2017.
 */
@WebServlet("/ShowDoctor")
public class ShowDoctor extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowDoctor.class);

    private DoctorService doctorService;
    private UserService userService;
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
        departmentService = (DepartmentService) servletContext.getAttribute("departmentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show doctor - start");
        HttpSession session = req.getSession();
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        Doctor doctor = doctorService.getDoctorById(doctorId);
        User user = userService.getUserById(doctor.getUserId());
        List<Department> departments = departmentService.getAllDepartment();

        req.setAttribute("doctor", doctor);
        req.setAttribute("user", user);
        req.setAttribute("departments", departments);

        req.getRequestDispatcher(SHOW_DOCTOR_PAGE).forward(req, resp);

        session.setAttribute("previousPageDoctor", req.getHeader("referer"));
        LOG.info("Show doctor - end");
    }
}
