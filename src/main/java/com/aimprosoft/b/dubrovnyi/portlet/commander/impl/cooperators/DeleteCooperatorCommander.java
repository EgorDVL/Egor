package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class DeleteCooperatorCommander implements DepartmentCommander {
    private CooperatorService cooperatorSpringService;

    public DeleteCooperatorCommander(
            CooperatorService cooperatorSpringService) {
        this.cooperatorSpringService = cooperatorSpringService;
    }

    @Override
    public void setJSPage(ActionRequest request,
                          Model model) {

        String cooperatorEmail = request
                .getParameter(COOPERATOR_OPERATION_EMAIL_VALUE);

        if (cooperatorSpringService.deleteCooperator(cooperatorEmail)) {
            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    SUCCESSFUL_PAGE_PATH);
        } else {
            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    ERROR_PAGE_PATH);
        }

    }
}
