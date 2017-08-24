package com.aimprosoft.b.dubrovnyi.portlet.commander.impl.departments;

import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import com.aimprosoft.b.dubrovnyi.portlet.commander.DepartmentCommander;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import org.springframework.ui.Model;

import javax.portlet.ActionRequest;
import java.util.List;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

public class ShowAllDepartmentsCommander implements DepartmentCommander {
    private DepartmentService departmentSpringService;

    public ShowAllDepartmentsCommander(
            DepartmentService departmentSpringService) {

        this.departmentSpringService = departmentSpringService;
    }

    @Override
    public void setJSPage(ActionRequest request, Model model) {
        setAttributes(model);

        model.addAttribute(CURRENT_JSP_PAGE_SESSION_VALUE,
                DEPARTMENTS_PAGE_PATH);
    }

    private void setAttributes(Model model) {
        List<Department> departments = departmentSpringService
                .getDepartments();

        model.addAttribute(DEPARTMENTS_LIST_VALUE, departments);
    }

}
