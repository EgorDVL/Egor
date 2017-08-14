package com.zhyzhko.service.impl;

import com.zhyzhko.dao.HibirnateDao.DepartmentDao;
import com.zhyzhko.dao.entity.Department;
import com.zhyzhko.exception.ServiceException;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.util.validators.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 03.07.17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private OvalValidator validator;

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional
    @Override
    public Department createOrUpdate(Department department) {
        validator.validate(department);
        return departmentDao.createOrUpdate(department);
    }


    @Transactional(readOnly = true)
    @Override
    public Department getDepartmentById(Integer departmentId) {
        return departmentDao.getById(departmentId);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAll();
    }


    @Transactional
    @Override
    public boolean deleteDepartment(Integer departmentId) {
        return departmentDao.delete(departmentId);
    }


    @Transactional(readOnly = true)
    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.getByName(name).orElse(null);
    }
}