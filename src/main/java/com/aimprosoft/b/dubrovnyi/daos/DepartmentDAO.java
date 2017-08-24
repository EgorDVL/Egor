package com.aimprosoft.b.dubrovnyi.daos;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;

import java.util.List;


public interface DepartmentDAO {

    public List<Department> getAllDepartments();

    public boolean deleteDepartmentByName(String departmentName);

    public boolean addNewDepartment(Department newDepartment);

    public boolean editDepartmentByName(String departmentName,
                                        Department newDepartmentData);

    public Department getDepartmentByName(String departmentName);
}
