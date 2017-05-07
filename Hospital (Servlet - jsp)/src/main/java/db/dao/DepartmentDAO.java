package db.dao;

import bean.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface DepartmentDAO {
    int createDepartment(Department department);

    Department getDepartmentById(int departmentId);

    List<Department> getAllDepartments();

    boolean updateDepartment(Department department);
}
