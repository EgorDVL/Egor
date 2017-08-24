package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import com.aimprosoft.b.dubrovnyi.validator.ValidatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;
import java.util.Map;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class CreateNewDepartmentCommander implements DepartmentCommander {

    private DepartmentService departmentSpringService;
    private ValidatorService validatorService;

    public CreateNewDepartmentCommander(
            DepartmentService departmentSpringService,
            ValidatorService validatorService) {

        this.departmentSpringService = departmentSpringService;
        this.validatorService = validatorService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String departmentName = request.getParameter(DEPARTMENT_NAME);

        Department department = new Department();
        department.setName(departmentName);

        Map<String, String> errorMap = validatorService
                .getDepartmentErrorMap(department, false, null);

        if (errorMap.isEmpty()) {
            if (departmentSpringService.createDepartment(department)) {
                model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                        SUCCESSFUL_PAGE_PATH);
                return;
            }
        } else {
            reloadPage(model, department, errorMap);

            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    CREATE_DEPARTMENT_PAGE_PATH);
            return;
        }

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                ERROR_PAGE_PATH);
    }

    private void reloadPage(Model model, Department department,
                            Map<String, String> errors) {
        model.addAttribute(DEPARTMENT_NAME, department.getName());

        model.addAttribute(DEPARTMENT_NAME_ERROR,
                errors.get(DEPARTMENT_NAME_ERROR));
    }
}
