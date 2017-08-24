package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;
import java.util.List;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class ShowCooperatorsCommander implements DepartmentCommander {

    private CooperatorService cooperatorSpringService;

    public ShowCooperatorsCommander(
            CooperatorService cooperatorSpringService) {
        this.cooperatorSpringService = cooperatorSpringService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String departmentName = request.getParameter(DEPARTMENT_OPERATION_NAME_VALUE);

        List<Cooperator> cooperators = cooperatorSpringService
                .getCooperators(departmentName);

        model.addAttribute(DEPARTMENT_COOPERATORS_LIST_VALUE, cooperators);
        model.addAttribute(COOPERATORS_DEPARTMENT_NAME_VALUE, departmentName);

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                DEPARTMENT_COOPERATORS_PAGE_PATH);
    }
}
