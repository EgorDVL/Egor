package com.zhyzhko.service;


import com.zhyzhko.dao.entity.Employee;

import java.util.List;

/**
 * Created by user on 03.07.17.
 */
public interface EmployeeService {

    Employee createOrUpdate(Employee employee);

    Employee getEmployeeById(Integer employeeId);

    Employee getEmployeeByEmail(String email);

    List<Employee> getAllEmployee();

    List<Employee> getAllEmployeeByDepartmentId(Integer departmentId);
    
    boolean updateEmployeeDepartmentId(Integer departmentId);

    boolean deleteEmployee(Integer employeeId);
}
