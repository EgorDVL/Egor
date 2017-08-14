package com.zhyzhko.web.controllers.employee;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.entity.Department;
import com.zhyzhko.dao.entity.Employee;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
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
import java.util.List;

import static com.zhyzhko.util.page.Pages.EMPLOYEE_PAGE;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/RedirectToEmployeeExecutePage")
public class RedirectToEmployeeExecutePage extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RedirectToEmployeeExecutePage.class);

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Redirect to employee execute page - start");

        String employeeId = req.getParameter("employeeId");
        if (!StringUtils.isEmpty(employeeId)) {

            Employee employee = employeeService.getEmployeeById(Integer.parseInt(employeeId));

            req.setAttribute("employee", employee);
            req.setAttribute("employeeDepartment",
                    departmentService.getDepartmentById(employee.getDepartment().getId()));

        }

        List<Department> departmentList = departmentService.getAllDepartments();
        req.setAttribute("departmentList", departmentList);

        req.getRequestDispatcher(EMPLOYEE_PAGE).forward(req, resp);

        LOG.info("Redirect to employee execute page - end");
    }
}
