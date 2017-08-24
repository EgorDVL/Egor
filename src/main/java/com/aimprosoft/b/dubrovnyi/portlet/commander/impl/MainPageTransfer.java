package com.aimprosoft.b.dubrovnyi.portlet.commander.impl;

import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.CURRENT_JSP_PAGE_SESSION_VALUE;
import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.HOME_PAGE;

public class MainPageTransfer implements DepartmentCommander {
    @Override
    public void setJSPage(ActionRequest request, Model model) {

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE, HOME_PAGE);
    }
}
