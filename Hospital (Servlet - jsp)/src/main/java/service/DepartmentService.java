package service;

import bean.Department;

import java.util.List;

/**
 * Created by Egor on 22.01.2017.
 */
public interface DepartmentService {

    List<Department> getAllDepartment();

    Department getDepartmentById(int departmentId);
}
