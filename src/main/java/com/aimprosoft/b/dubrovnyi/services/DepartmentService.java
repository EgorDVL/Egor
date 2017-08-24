package com.aimprosoft.b.dubrovnyi.services;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;

import java.util.List;

/**
 * Created by user on 12.07.17.
 */
public interface DepartmentService {
    public List<Department> getDepartments();

    public boolean deleteDepartment(String departmentName);

    public boolean createDepartment(Department newDepartment);

    public boolean editDepartment(String departmentName,
                                  Department newDepartmentData);

    public Department getDepartment(String departmentName);
}

