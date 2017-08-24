package com.aimprosoft.b.dubrovnyi.daos.spring;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("cooperatorJpa")
@Component
public interface CooperatorJpaDao extends JpaRepository<Cooperator, Integer> {

    @Query("select cooperator from Cooperator cooperator join cooperator.department dep "
            + "where dep.name = :departmentName")
    public List<Cooperator> getCooperatorsByDepartmentName(
            @Param("departmentName") String departmentName);

    @Query("select cooperator from Cooperator cooperator "
            + "where cooperator.email = :cooperatorEmail")
    public Cooperator getCooperatorByEmail(
            @Param("cooperatorEmail") String cooperatorEmail);

}
