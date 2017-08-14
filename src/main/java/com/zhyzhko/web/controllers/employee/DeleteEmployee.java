package com.zhyzhko.web.controllers.employee;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.service.DepartmentService;
import org.apache.log4j.Logger;
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
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DeleteEmployee.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        employeeService = context.getBean(EmployeeService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Delete Employee - start");

        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        employeeService.deleteEmployee(employeeId);

        resp.sendRedirect("ShowAllEmployees");

        LOG.info("Delete Employee - end");
    }
}
