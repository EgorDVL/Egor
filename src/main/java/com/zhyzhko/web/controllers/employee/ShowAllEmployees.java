package com.zhyzhko.web.controllers.employee;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.entity.Employee;
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
import java.util.List;

import static com.zhyzhko.util.page.Pages.SHOW_ALL_EMPLOYEES;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/ShowAllEmployees")
public class ShowAllEmployees extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ShowAllEmployees.class);

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
        LOG.info("Show all employee - start");

        List<Employee> employeeList = employeeService.getAllEmployee();
        req.setAttribute("employeeList", employeeList);

        req.getRequestDispatcher(SHOW_ALL_EMPLOYEES).forward(req, resp);

        LOG.info("Show all employee - end");
    }
}
