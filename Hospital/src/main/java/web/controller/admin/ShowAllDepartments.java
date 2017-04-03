package web.controller.admin;

import bean.Department;
import bean.Doctor;
import bean.Nurse;
import org.apache.log4j.Logger;
import service.DepartmentService;
import service.DoctorService;
import service.NurseService;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.NurseServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.Page.DEPARTMENTS_DOCTORS_PAGE;
import static util.page.Page.SHOW_ALL_DEPARTMENTS_PAGE;
import static util.page.Page.SHOW_ALL_DOCTORS_PAGE;

/**
 * Created by Egor on 12.01.2017.
 */
@WebServlet("/ShowAllDepartments")
public class ShowAllDepartments extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllDepartments.class);
    private DoctorService doctorService;
    private NurseService nurseService;
    private DepartmentService departmentService;

    public ShowAllDepartments() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
        departmentService = (DepartmentService) servletContext.getAttribute("departmentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all department - start");

        List<Department> departmentList = departmentService.getAllDepartment();

        req.setAttribute("departmentList", departmentList);
        req.getRequestDispatcher(SHOW_ALL_DEPARTMENTS_PAGE).forward(req, resp);

        LOG.info("Show all healing - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all doctors in department - start");

        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        List<Doctor> doctorList = doctorService.getAllDoctorsByDepartmentId(departmentId);
        List<Nurse> nurseList = nurseService.getAllNurseByDepartmentId(departmentId);
        req.setAttribute("nurseList", nurseList);
        req.setAttribute("doctorList", doctorList);
        req.getRequestDispatcher(DEPARTMENTS_DOCTORS_PAGE).forward(req, resp);

        LOG.info("Show all doctors in department - end");
    }
}
