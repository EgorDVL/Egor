package db.rowmapper.impl;

import bean.Department;
import bean.enums.DepartmentEnum;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class DepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department extract(ResultSet set) throws SQLException {
        Department department = new Department();
        department.setDepartmentId(set.getInt(1));
        department.setDepartmentEnum(DepartmentEnum.getValue(set.getString(2)));
        return department;
    }
}
