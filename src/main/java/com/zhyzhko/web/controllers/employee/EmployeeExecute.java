package com.zhyzhko.web.controllers.employee;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.entity.Employee;
import com.zhyzhko.service.EmployeeService;
import com.zhyzhko.util.validators.OvalValidator;
import com.zhyzhko.web.requestConverter.HttpRequestConverter;
import com.zhyzhko.web.requestConverter.impl.EmployeeRequestConverter;
import org.apache.log4j.Logger;
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

import static com.zhyzhko.util.page.Pages.EMPLOYEE_PAGE;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/EmployeeExecute")
public class EmployeeExecute extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(EmployeeExecute.class);
    private static final String ERROR_PAGE = EMPLOYEE_PAGE;

    private HttpRequestConverter<Employee> requestConverter = new EmployeeRequestConverter();

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
        LOG.info("Update Employee - start");
        Employee employee = requestConverter.fromRequest(req);

//        if (OvalValidator.validation(employee, ERROR_PAGE, req, resp)) {

            employeeService.createOrUpdate(employee);

            resp.sendRedirect("ShowAllEmployees");
//        }
        LOG.info("Update Employee - end");
    }
}
