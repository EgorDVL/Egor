package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.CREATE_DEPARTMENT_PAGE_PATH;
import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.CURRENT_JSP_PAGE_SESSION_VALUE;

public class CreateDepartmentPageTransfer implements DepartmentCommander {

    @Override
    public void setJSPage(ActionRequest request, Model model) {
        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                CREATE_DEPARTMENT_PAGE_PATH);
    }
}
