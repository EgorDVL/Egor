package com.aimprosoft.b.dubrovnyi.portlet;

import com.aimprosoft.b.dubrovnyi.portlet.commander.impl.MainPageTransfer;
import com.aimprosoft.b.dubrovnyi.portlet.commander.impl.cooperators.*;
import com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments.*;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import com.aimprosoft.b.dubrovnyi.validator.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.CURRENT_JSP_PAGE_SESSION_VALUE;
import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.HOME_PAGE;

/**
 * @author Bohdan Dubrovnyi
 */

@Controller(value = "departmentMVCPortlet")
@RequestMapping("VIEW")
@SessionAttributes(CURRENT_JSP_PAGE_SESSION_VALUE)
public class DepartmentMVCPortlet {

    private static final String ACTION_PARAMETER = "action";

    @Autowired
    private DepartmentService departmentSpringService;

    @Autowired
    private CooperatorService cooperatorSpringService;

    @Autowired
    private ValidatorService validatorService;

    @ActionMapping(value = "show-departments")
    public void handlShowDepartments(ActionRequest request,
                                     Model model) {

        new ShowAllDepartmentsCommander(departmentSpringService)
                .setJSPage(request, model);
    }

    @ActionMapping(value = "edit-department")
    public void handleEditDepartment(ActionRequest request,
                                     Model model) {

        new EditDepartmentCommander(departmentSpringService,
                validatorService).setJSPage(request, model);
    }

    @ActionMapping(value = "transfer-edit-department")
    public void handleTransferEditDepartment(ActionRequest request,
                                             Model model) {

        new EditDepartmentPageTransfer().setJSPage(request, model);
    }

    @ActionMapping(value = "delete-department")
    public void handleDeleteDepartment(ActionRequest request,
                                       Model model) {

        new DeleteDepartmentCommander(departmentSpringService)
                .setJSPage(request, model);
    }

    @ActionMapping(value = "create-department")
    public void handleCreateDepartment(ActionRequest request,
                                       Model model) {

        new CreateNewDepartmentCommander(departmentSpringService,
                validatorService).setJSPage(request, model);
    }


    @ActionMapping(value = "transfer-create-department")
    public void handleTransferCreateDepartment(ActionRequest request,
                                               Model model) {

        new CreateDepartmentPageTransfer().setJSPage(request, model);
    }

    @ActionMapping(value = "show-cooperators")
    public void handleShowCooperators(ActionRequest request,
                                      Model model) {

        new ShowCooperatorsCommander(cooperatorSpringService)
                .setJSPage(request, model);
    }

    @ActionMapping(value = "edit-cooperator")
    public void handleEditCooperator(ActionRequest request,
                                     Model model) {

        new EditCooperatorCommander(cooperatorSpringService,
                validatorService).setJSPage(request, model);
    }


    @ActionMapping(value = "transfer-edit-cooperator")
    public void handleTransferEditCooperator(ActionRequest request,
                                             Model model) {

        new EditCooperatorPageTransfer(cooperatorSpringService)
                .setJSPage(request, model);
    }

    @ActionMapping(value = "add-cooperator")
    public void handleAddCooperator(ActionRequest request,
                                    Model model) {

        new CreateNewCooperatorCommander(departmentSpringService,
                cooperatorSpringService, validatorService)
                .setJSPage(request, model);
    }


    @ActionMapping(value = "transfer-add-cooperator")
    public void handleTransferAddCooperator(ActionRequest request,
                                            Model model) {

        new CreateCooperatorTransfer().setJSPage(request, model);
    }

    @ActionMapping(value = "delete-cooperator")
    public void handleDeleteCooperator(ActionRequest request,
                                       Model model) {

        new DeleteCooperatorCommander(cooperatorSpringService)
                .setJSPage(request, model);
    }


    @ActionMapping(value = "main-page")
    public void handleTransferMainPage(ActionRequest request,
                                       Model model) {

        new MainPageTransfer().setJSPage(request, model);
    }


    /*
    Never uncomment this method, `cause you'll take further ex-tion:
        org.springframework.web.portlet.NoHandlerFoundException:
            No handler found for portlet request: mode 'view', phase 'RENDER_PHASE'
     */
    @RenderMapping
    public String pageTransferMapper(RenderRequest request,
                                     RenderResponse response,
                                     Model model) {

        String currentJSPage = (String) request.getPortletSession()
                .getAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                        PortletSession.PORTLET_SCOPE);

        if (!model.containsAttribute(CURRENT_JSP_PAGE_SESSION_VALUE)) {
            model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE, HOME_PAGE);
            currentJSPage = HOME_PAGE;
        }

        return currentJSPage;
    }

}
