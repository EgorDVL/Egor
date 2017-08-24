package com.aimprosoft.b.dubrovnyi.daos.spring;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentJpa")
@Component
public interface DepartmentJpaDao extends JpaRepository<Department, Integer> {

    @Query("select department from Department department")
    public List<Department> getAllDepartments();

    @Query("select department from Department department "
            + "where department.name = :departmentName")
    public Department getDepartmentByName(
            @Param("departmentName") String departmentName);
}
