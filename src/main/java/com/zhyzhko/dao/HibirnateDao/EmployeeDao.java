package com.zhyzhko.dao.HibirnateDao;


import com.zhyzhko.dao.entity.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 03.07.17.
 */
public interface EmployeeDao {

    //Hibernate
    Employee createOrUpdate(Employee employee);

    Employee getById(Integer employeeId);

    Optional<Employee> getByEmail(String email);

    List<Employee> getAll();

    List<Employee> getAllByDepartmentId(Integer departmentId);
    
    boolean updateDepartmentId(Employee employee);

    boolean delete(Integer employeeId);
}
