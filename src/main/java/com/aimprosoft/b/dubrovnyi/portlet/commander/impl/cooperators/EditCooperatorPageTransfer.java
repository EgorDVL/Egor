package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class EditCooperatorPageTransfer implements DepartmentCommander {

    private CooperatorService cooperatorSpringService;

    public EditCooperatorPageTransfer(
            CooperatorService cooperatorSpringService) {
        this.cooperatorSpringService = cooperatorSpringService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String oldCooperatorEmail = request
                .getParameter(COOPERATOR_OPERATION_EMAIL_VALUE);

        model.addAttribute(OLD_COOPERATOR_EMAIL_VALUE, oldCooperatorEmail);

        Cooperator cooperator = cooperatorSpringService
                .getCooperator(oldCooperatorEmail);

        model.addAttribute(COOPERATOR_NAME, cooperator.getName());
        model.addAttribute(COOPERATOR_SURNAME_VALUE, cooperator.getSurname());
        model.addAttribute(COOPERATOR_EMAIL_VALUE, cooperator.getEmail());
        model.addAttribute(COOPERATOR_REG_DATE_VALUE,
                cooperator.getRegistrationDate().toString());

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                EDIT_COOPERATOR_PAGE_PATH);
    }
}
