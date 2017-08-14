package com.zhyzhko.util;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.HibirnateDao.DepartmentDao;
import com.zhyzhko.dao.HibirnateDao.impl.DepartmentDaoHibernate;
import com.zhyzhko.dao.entity.Employee;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static com.zhyzhko.util.page.Pages.EMPLOYEE_PAGE;

/**
 * Created by user on 11.07.17.
 */
public class EmployeeDepartmentSender {

    //JDBC
//    private static DepartmentDaoJdbc departmentDao = new DepartmentDaoJdbcImpl();
//    private static DepartmentService departmentService = TransactionProxyManager.getTransactionalWrapper(new DepartmentServiceImpl(departmentDao));

    //Hibernate

    @Autowired
    private static DepartmentService departmentService;

    public static void sendEmployeeDepartmentToPage(Object o, String errorPage, HttpServletRequest req) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        departmentService = context.getBean(DepartmentService.class);

        if (errorPage.equalsIgnoreCase(EMPLOYEE_PAGE)) {
            Employee employee = (Employee) o;

            req.setAttribute("departmentList", departmentService.getAllDepartments());
            req.setAttribute("employeeDepartment", departmentService.getDepartmentById(employee.getDepartment().getId()));
        }
    }
}
