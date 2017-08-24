package com.aimprosoft.b.dubrovnyi.services.impl;

import com.aimprosoft.b.dubrovnyi.daos.spring.DepartmentJpaDao;
import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departmentSpringService")
public class DepartmentSpringServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentJpaDao departmentJpa;

    @Override
    @Transactional(readOnly = true)
    public List<Department> getDepartments() {
        return departmentJpa.getAllDepartments();
    }

    @Override
    @Transactional
    public boolean deleteDepartment(String departmentName) {
        return deleteDepartmentByName(departmentName);
    }

    @Override
    @Transactional
    public boolean createDepartment(Department newDepartment) {
        return departmentJpa.saveAndFlush(newDepartment) != null;
    }

    @Override
    @Transactional
    public boolean editDepartment(String departmentName,
                                  Department newDepartmentData) {
        return updateDepartment(departmentName, newDepartmentData);
    }

    @Override
    public Department getDepartment(String departmentName) {
        return departmentJpa.getDepartmentByName(departmentName);
    }

    private boolean deleteDepartmentByName(String departmentName) {
        Department departmentForDeleting = departmentJpa
                .getDepartmentByName(departmentName);
        if (departmentForDeleting == null) {
            return false;
        }

        departmentJpa.delete(departmentForDeleting);
        return true;
    }

    private boolean updateDepartment(String departmentName,
                                     Department newDepartmentData) {
        Department currentDepartment = departmentJpa
                .getDepartmentByName(departmentName);

        currentDepartment.setName(newDepartmentData.getName());
        return departmentJpa.saveAndFlush(currentDepartment) != null;
    }
}
