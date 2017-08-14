package com.zhyzhko.web.controllersMVC;

import com.zhyzhko.dao.entity.Department;
import com.zhyzhko.exception.ValidationException;
import com.zhyzhko.service.DepartmentService;
import com.zhyzhko.service.EmployeeService;
import com.zhyzhko.util.validators.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * Created on 18.07.17.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public List<Department> showAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @PostMapping(value = "/delete")
    public boolean deleteDepartment(@RequestParam Integer departmentId) {
        employeeService.updateEmployeeDepartmentId(departmentId);
        return departmentService.deleteDepartment(departmentId);
    }

    @GetMapping(value = "/getDepartment")
    public Department getDepartment(@RequestParam Integer departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping(value = "/departmentExecute", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department departmentExecute(@RequestBody Department department) {
        return departmentService.createOrUpdate(department);
    }
}