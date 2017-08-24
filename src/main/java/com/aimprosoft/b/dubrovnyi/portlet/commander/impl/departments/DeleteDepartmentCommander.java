package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class DeleteDepartmentCommander implements DepartmentCommander {
    private DepartmentService departmentSpringService;

    public DeleteDepartmentCommander(
            DepartmentService departmentSpringService) {

        this.departmentSpringService = departmentSpringService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String departmentName = request.getParameter(DEPARTMENT_OPERATION_NAME_VALUE);

        if (departmentSpringService.deleteDepartment(departmentName)) {

            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    SUCCESSFUL_PAGE_PATH);
        } else {
            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    ERROR_PAGE_PATH);
        }
    }
}
