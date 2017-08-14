package com.zhyzhko.dao.HibirnateDao;


import com.zhyzhko.dao.entity.Department;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 03.07.17.
 */
public interface DepartmentDao {

    //Hibernate
    Department createOrUpdate(Department department);

    Department getById(Integer departmentId);

    Optional<Department> getByName(String name);
    
    List<Department> getAll();

    boolean delete(Integer departmentId);

}
