package db.dao.impl;

import bean.Department;
import db.dao.DepartmentDAO;
import db.rowmapper.impl.DepartmentRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class DepartmentDAOimpl implements DepartmentDAO {

    private static final String CREATE_DEPARTMENT = "insert into department values(default, ?)";
    private static final String GET_DEPARTMENT_BY_ID = "select * from department where departmentId = ?";
    private static final String GET_ALL_DEPARTMENT = "select * from department";
    private static final String UPDATE_DEPARTMENT = "update department set name = ? where departmentId = ?";

    private JdbcTemplate<Department> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createDepartment(Department department) {
        return jdbcTemplate.create(CREATE_DEPARTMENT, department.getDepartmentEnum().toString());
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return jdbcTemplate.get(GET_DEPARTMENT_BY_ID, new DepartmentRowMapper(), departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return jdbcTemplate.getAll(GET_ALL_DEPARTMENT, new DepartmentRowMapper());
    }

    @Override
    public boolean updateDepartment(Department department) {
        return jdbcTemplate.update(UPDATE_DEPARTMENT, department.getDepartmentEnum().toString(), department.getDepartmentId());
    }
}
