package com.zhyzhko.util.validators;

import com.zhyzhko.dao.entity.Department;
import com.zhyzhko.service.DepartmentService;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by user on 11.07.17.
 */
@Component
public class DepartmentVerification implements CheckWithCheck.SimpleCheck {

    @Autowired
    private DepartmentService departmentService;

    public boolean isSatisfied(Object department, Object name) {
        Department department1 = (Department) department;
        department1.setName((String) name);

        Department departmentTest = departmentService.getDepartmentByName(department1.getName());

        return departmentTest == null || Objects.equals(departmentTest.getId(), department1.getId());
    }
}