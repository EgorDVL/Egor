//package com.zhyzhko.web.listener;
//
//import com.zhyzhko.dao.HibirnateDao.impl.DepartmentDaoHibernate;
//import com.zhyzhko.dao.HibirnateDao.impl.EmployeeDaoHibernate;
//import com.zhyzhko.service.DepartmentService;
//import com.zhyzhko.service.EmployeeService;
//import com.zhyzhko.service.impl.DepartmentServiceImpl;
//import com.zhyzhko.service.impl.EmployeeServiceImpl;
//import com.zhyzhko.util.date.DateUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
///**
// * Created by user on 03.07.17.
// */
//@WebListener
//public class ApplicationListener implements ServletContextListener {
//    public static final Logger LOG = Logger.getLogger(com.zhyzhko.web.listener.ApplicationListener.class);
//
//    //    private DepartmentDaoJdbc departmentDaoJdbc;
////    private EmployeeDaoJdbc employeeDaoJdbc;
//    private DepartmentDaoHibernate departmentDao;
//    private EmployeeDaoHibernate employeeDao;
//
//    private DepartmentService departmentService;
//    private EmployeeService employeeService;
//
//    private DateUtils dateUtils;
//
//    public ApplicationListener() {
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        LOG.info("Start of initialization of application context");
//        ServletContext servletContext = sce.getServletContext();
//        initDaoLayer(servletContext);
//        initDateUtils(servletContext);
//        initServiceLayer(servletContext);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        LOG.info("Destroy application context");
//    }
//
//    private void initDaoLayer(ServletContext servletContext) {
//        LOG.info("Start of initialization of DAO layer...");
//
//        // JDBC realization
////        departmentDaoJdbc = new DepartmentDaoJdbcImpl();
////        employeeDaoJdbc = new EmployeeDaoJdbcImpl();
//
//        // Hibernate realization
//        departmentDao = new DepartmentDaoHibernate();
//        employeeDao = new EmployeeDaoHibernate();
//    }
//
//    private void initDateUtils(ServletContext servletContext) {
//        LOG.info("Start of initialization of date com.zhyzhko.util layer...");
//        dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
//        servletContext.setAttribute("dateUtils", dateUtils);
//    }
//
//    private void initServiceLayer(ServletContext servletContext) {
//        LOG.info("Start of initialization of com.zhyzhko.service layer...");
//
//        //For JDBC transaction with My class (TransactionProxyManager)
////        departmentService = TransactionProxyManager.getTransactionalWrapper(new DepartmentServiceImpl(departmentDaoJdbc));
////        employeeService = TransactionProxyManager.getTransactionalWrapper(new EmployeeServiceImpl(employeeDaoJdbc));
//
//        //For hibernate, with hibernate transaction
//        departmentService = new DepartmentServiceImpl(departmentDao);
//        employeeService = new EmployeeServiceImpl(employeeDao);
//
//        servletContext.setAttribute("departmentService", departmentService);
//        servletContext.setAttribute("employeeService", employeeService);
//
//        LOG.info("End of initialization of com.zhyzhko.service layer.");
//    }
//}
