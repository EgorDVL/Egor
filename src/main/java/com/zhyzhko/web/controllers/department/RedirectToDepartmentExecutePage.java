package com.zhyzhko.web.controllers.department;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.service.DepartmentService;
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

import static com.zhyzhko.util.page.Pages.DEPARTMENT_PAGE;

/**
 * Created by user on 04.07.17.
 */
@Component
@WebServlet("/RedirectToDepartmentExecutePage")
public class RedirectToDepartmentExecutePage extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RedirectToDepartmentExecutePage.class);

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
        LOG.info("Redirect to update department page - start");

        String departmentId = req.getParameter("departmentId");
        if (!StringUtils.isEmpty(departmentId)) {
            req.setAttribute("department", departmentService.getDepartmentById(Integer.parseInt(req.getParameter("departmentId"))));
        }
        req.getRequestDispatcher(DEPARTMENT_PAGE).forward(req, resp);

        LOG.info("Redirect to update department page - end");
    }
}
