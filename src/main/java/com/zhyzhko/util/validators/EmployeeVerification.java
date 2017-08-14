package com.zhyzhko.util.validators;

import com.zhyzhko.dao.entity.Employee;
import com.zhyzhko.service.EmployeeService;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by user on 11.07.17.
 */
@Component
public class EmployeeVerification implements CheckWithCheck.SimpleCheck {

    @Autowired
    private EmployeeService employeeService;

    public boolean isSatisfied(Object employee, Object email) {
        Employee employee1 = (Employee) employee;
        employee1.setEmail((String) email);

        Employee employeeTest = employeeService.getEmployeeByEmail(employee1.getEmail());

        return employeeTest == null || Objects.equals(employeeTest.getId(), employee1.getId());
    }
}