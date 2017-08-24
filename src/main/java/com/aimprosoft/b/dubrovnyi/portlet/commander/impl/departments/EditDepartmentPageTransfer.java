package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class EditDepartmentPageTransfer implements DepartmentCommander {

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String departmentName = request
                .getParameter(DEPARTMENT_OPERATION_NAME_VALUE);

        model.addAttribute(DEPARTMENT_NAME, departmentName);
        model.addAttribute(OLD_DEPARTMENTS_NAME_VALUE, departmentName);

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                EDIT_DEPARTMENTS_PAGE_PATH);
    }
}
