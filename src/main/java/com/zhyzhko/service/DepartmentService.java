package com.zhyzhko.service;


import com.zhyzhko.dao.entity.Department;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 03.07.17.
 */
public interface DepartmentService {

    Department createOrUpdate(Department department);

    Department getDepartmentById(Integer departmentId);

    Department getDepartmentByName(String name);

    List<Department> getAllDepartments();
    
    boolean deleteDepartment(Integer departmentId);
}
