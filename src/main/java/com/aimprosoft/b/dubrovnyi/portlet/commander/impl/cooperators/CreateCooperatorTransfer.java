package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class CreateCooperatorTransfer implements DepartmentCommander {
    @Override
    public void setJSPage(ActionRequest request,
                          Model model) {
        String departmentName = request.getParameter(DEPARTMENTS_NAME_VALUE);

        model.addAttribute(COOPERATORS_DEPARTMENT_NAME_VALUE, departmentName);

        //set JSPage:
        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                CREATE_COOPERATOR_PAGE_PATH);
    }
}
