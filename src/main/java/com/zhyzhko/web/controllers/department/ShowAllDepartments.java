package com.zhyzhko.web.controllers.department;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.entity.Department;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.service.impl.DepartmentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.zhyzhko.util.page.Pages.SHOW_ALL_DEPARTMENTS;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/ShowAllDepartments")
public class ShowAllDepartments extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ShowAllDepartments.class);

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        departmentService = context.getBean(DepartmentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all departments - start");

        List<Department> departmentList = departmentService.getAllDepartments();
        sortDepartmentsById(departmentList);

        req.setAttribute("departmentList", departmentList);
        req.getRequestDispatcher(SHOW_ALL_DEPARTMENTS).forward(req, resp);

        LOG.info("Show all departments - end");
    }

    private void sortDepartmentsById(List<Department> departmentList) {
        departmentList.sort(Comparator.comparingInt(Department::getId));
    }
}
