package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import com.aimprosoft.b.dubrovnyi.validator.ValidatorService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;
import java.sql.Date;
import java.util.Map;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;
import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.COOPERATOR_REG_DATE_ERROR;

public class EditCooperatorCommander implements DepartmentCommander {

    private CooperatorService cooperatorSpringService;
    private ValidatorService validatorService;

    public EditCooperatorCommander(CooperatorService cooperatorSpringService,
                                   ValidatorService validatorService) {

        this.cooperatorSpringService = cooperatorSpringService;
        this.validatorService = validatorService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {

        String oldCooperatorEmail = request
                .getParameter(OLD_COOPERATOR_EMAIL_VALUE);

        String name = request.getParameter(COOPERATOR_NAME);
        String surname = request.getParameter(COOPERATOR_SURNAME_VALUE);
        String email = request.getParameter(COOPERATOR_EMAIL_VALUE);
        String cooperatorRegDate = request
                .getParameter(COOPERATOR_REG_DATE_VALUE);

        Cooperator cooperator = cooperatorSpringService
                .getCooperator(oldCooperatorEmail);
        cooperator.setName(name);
        cooperator.setSurname(surname);
        cooperator.setEmail(email);

        Map<String, String> errorMap = validatorService
                .getCooperatorErrorMap(cooperator, cooperatorRegDate,
                        true, oldCooperatorEmail);

        if (errorMap.isEmpty()) {
            cooperator.setRegistrationDate(Date.valueOf(cooperatorRegDate));

            if (cooperatorSpringService.editCooperator(oldCooperatorEmail,
                    cooperator)) {
                model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                        SUCCESSFUL_PAGE_PATH);
                return;
            }
        } else {
            setPreviousValuesWithErrors(model, cooperator,
                    cooperatorRegDate, errorMap);

            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                    EDIT_COOPERATOR_PAGE_PATH);
            return;
        }

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                ERROR_PAGE_PATH);
    }

    private void setPreviousValuesWithErrors(Model model,
                                             Cooperator cooperator,
                                             String registrationDate,
                                             Map<String, String> errors) {

        model.addAttribute(COOPERATOR_NAME, cooperator.getName());
        model.addAttribute(COOPERATOR_SURNAME_VALUE, cooperator.getSurname());
        model.addAttribute(COOPERATOR_EMAIL_VALUE, cooperator.getEmail());
        model.addAttribute(COOPERATOR_REG_DATE_VALUE, registrationDate);

        model.addAttribute(COOPERATOR_NAME_ERROR,
                errors.get(COOPERATOR_NAME_ERROR));
        model.addAttribute(COOPERATOR_SURNAME_ERROR,
                errors.get(COOPERATOR_SURNAME_ERROR));
        model.addAttribute(COOPERATOR_EMAIL_ERROR,
                errors.get(COOPERATOR_EMAIL_ERROR));
        model.addAttribute(COOPERATOR_REG_DATE_ERROR,
                errors.get(COOPERATOR_REG_DATE_ERROR));
    }
}
