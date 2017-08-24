//package com.zhyzhko.web.controllersMVC;
//
//import com.zhyzhko.dao.entity.Employee;
//import com.zhyzhko.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Created on 18.07.17.
// */
//@Controller
//@RequestMapping("/employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @RequestMapping(value = "/all")
//    public List<Employee> showAllEmployee() {
//        return employeeService.getAllEmployee();
//    }
//
//    @RequestMapping(value = "/getEmployee")
//    public Employee getEmployee(@RequestParam Integer employeeId) {
//        return employeeService.getEmployeeById(employeeId);
//    }
//
//    @RequestMapping(value = "/delete")
//    public boolean deleteEmployee(@RequestParam Integer employeeId) {
//        return employeeService.deleteEmployee(employeeId);
//    }
//
//    @RequestMapping(value = "/allDepartmentEmployees")
//    public List<Employee> showAllDepartmentEmployees(@RequestParam Integer departmentId) {
//        return employeeService.getAllEmployeeByDepartmentId(departmentId);
//    }
//
//    @RequestMapping(value = "/employeeExecute", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Employee employeeExecute(@RequestBody Employee employee) {
//        return employeeService.createOrUpdate(employee);
//    }
//}