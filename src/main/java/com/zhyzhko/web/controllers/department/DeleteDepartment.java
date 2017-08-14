package com.zhyzhko.web.controllers.department;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.entity.Employee;
import org.apache.log4j.Logger;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/DeleteDepartment")
public class DeleteDepartment extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(DeleteDepartment.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        departmentService = context.getBean(DepartmentService.class);
        employeeService = context.getBean(EmployeeService.class);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Delete Department - start");

        int departmentId = Integer.parseInt(req.getParameter("departmentId"));

        employeeService.updateEmployeeDepartmentId(departmentId);
        departmentService.deleteDepartment(departmentId);

        resp.sendRedirect("ShowAllDepartments");

        LOG.info("Delete Department - end");
    }
}
