package com.zhyzhko.service.impl;

import com.zhyzhko.dao.HibirnateDao.EmployeeDao;
import com.zhyzhko.dao.entity.Employee;
import com.zhyzhko.exception.ObtainObjectException;
import com.zhyzhko.exception.PersistException;
import com.zhyzhko.exception.ServiceException;
import com.zhyzhko.service.EmployeeService;
import com.zhyzhko.util.validators.OvalValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 03.07.17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private OvalValidator validator;

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    @Override
    public Employee createOrUpdate(Employee employee) {
        validator.validate(employee);
        return employeeDao.createOrUpdate(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.getById(employeeId);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeDao.getByEmail(email).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployeeByDepartmentId(Integer departmentId) {
        return employeeDao.getAllByDepartmentId(departmentId);
    }

    @Transactional
    @Override
    public boolean updateEmployeeDepartmentId(Integer departmentId) {
        List<Employee> employeeList = employeeDao.getAllByDepartmentId(departmentId);
        for (Employee employee : employeeList) {
            employeeDao.updateDepartmentId(employee);
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deleteEmployee(Integer employeeId) {
        return employeeDao.delete(employeeId);
    }
}