package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import com.aimprosoft.b.dubrovnyi.validator.ValidatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import java.util.Map;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class EditDepartmentCommander implements DepartmentCommander {

    private DepartmentService departmentSpringService;
    private ValidatorService validatorService;

    public EditDepartmentCommander(DepartmentService departmentSpringService,
                                   ValidatorService validatorService) {

        this.departmentSpringService = departmentSpringService;
        this.validatorService = validatorService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String newDepartmentName = request.getParameter(DEPARTMENT_NAME);
        String oldDepartmentName = request.getParameter(OLD_DEPARTMENTS_NAME_VALUE);

        Department department = new Department();
        department.setName(newDepartmentName);

        Map<String, String> errorMap = validatorService
                .getDepartmentErrorMap(department, true, oldDepartmentName);

        if (errorMap.isEmpty()) {
            if (departmentSpringService.editDepartment(oldDepartmentName,
                    department)) {

                model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                        SUCCESSFUL_PAGE_PATH);
                return;
            }
        } else {
            reloadPage(model, department, errorMap, oldDepartmentName);

            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    EDIT_DEPARTMENTS_PAGE_PATH);
            return;
        }

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                ERROR_PAGE_PATH);
    }

    private void reloadPage(Model model, Department department,
                            Map<String, String> errors,
                            String oldDepartmentName) {

        model.addAttribute(DEPARTMENT_NAME, department.getName());
        model.addAttribute(OLD_DEPARTMENTS_NAME_VALUE, oldDepartmentName);

        model.addAttribute(DEPARTMENT_NAME_ERROR,
                errors.get(DEPARTMENT_NAME_ERROR));
    }
}
