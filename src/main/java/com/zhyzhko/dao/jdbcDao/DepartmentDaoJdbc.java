package com.zhyzhko.dao.jdbcDao;


import com.zhyzhko.models.Department;

import java.util.List;

/**
 * Created by user on 03.07.17.
 */
public interface DepartmentDaoJdbc {

    void createOrUpdate(Department department);

    int create(Department department);

    Department getById(int departmentId);

    List<Department> getAll();

    boolean update(Department department);

    boolean delete(int departmentId);

    Department getByName(String name);
}
