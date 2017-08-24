package com.aimprosoft.b.dubrovnyi.constants;

public class ConstantClass {
    public static final int PRIME_NUMBER = 31;
    public static final int WRONG_ID = -1;

    public static final String HOME_PAGE = "view";

    public static final String DEPARTMENTS_PAGE_PATH =
            "department/departments-page";
    public static final String EDIT_DEPARTMENTS_PAGE_PATH =
            "department/edit-department-page";
    public static final String CREATE_DEPARTMENT_PAGE_PATH =
            "department/department-add-page";

    public static final String ERROR_PAGE_PATH =
            "service-pages/error-page";
    public static final String SUCCESSFUL_PAGE_PATH =
            "service-pages/successful-operation-page";
    public static final String DEPARTMENT_COOPERATORS_PAGE_PATH =
            "cooperator/cooperators-list-page";

    public static final String EDIT_COOPERATOR_PAGE_PATH =
            "cooperator/edit-cooperator-page";

    public static final String CREATE_COOPERATOR_PAGE_PATH =
            "cooperator/cooperator-add-page";

    public static final String DEPARTMENTS_LIST_VALUE = "departmentsList";
    public static final String DEPARTMENTS_NAME_VALUE = "departmentName";
    public static final String OLD_DEPARTMENTS_NAME_VALUE =
            "oldDepartmentName";
    public static final String NEW_DEPARTMENTS_NAME_VALUE =
            "newDepartmentName";
    public static final String DEPARTMENT_COOPERATORS_LIST_VALUE =
            "departmentCooperatorsList";

    public static final String COOPERATORS_DEPARTMENT_NAME_VALUE =
            "cooperatorsDepartment";
    public static final String COOPERATOR_NAME = "name";
    public static final String DEPARTMENT_NAME = "name";

    public static final String COOPERATOR_NAME_VALUE = "cooperatorName";
    public static final String COOPERATOR_SURNAME_VALUE = "surname";
    public static final String COOPERATOR_EMAIL_VALUE = "email";
    public static final String OLD_COOPERATOR_EMAIL_VALUE =
            "oldCooperatorEmail";
    public static final String COOPERATOR_REG_DATE_VALUE = "cooperatorRegDate";

    public static final String EDIT_VALUE = "edit";
    public static final String DELETE_VALUE = "delete";
    public static final String SHOW_COOPERATORS_VALUE = "showCooperators";

    public static final String COOPERATOR_OPERATION_TYPE_VALUE =
            "cooperatorOperationType";
    public static final String COOPERATOR_OPERATION_EMAIL_VALUE =
            "cooperatorOperationEmail";

    public static final String OPERATION_TYPE_VALUE = "operationType";
    public static final String DEPARTMENT_OPERATION_NAME_VALUE =
            "departmentOperationName";

    public static final String CURRENT_JSP_PAGE_SESSION_VALUE =
            "currentJSPage";


    public static final String SPRING_CONFIG_PATH_FILE =
            "classpath:app-context.xml";

    public static final String DEPARTMENT_SERVICE_BEAN_NAME = "departmentService";
    public static final String COOPERATOR_SERVICE_BEAN_NAME = "cooperatorService";

    //Queries Names:
    public static final String COOPERATOR_LIST_BY_DEP_NAME_Q_NAME =
            "COOPERATOR.LIST.BY.DEP.NAME";
    public static final String COOPERATOR_BY_EMAIL_Q_NAME =
            "COOPERATOR.BY.EMAIL";

    public static final String DEPARTMENTS_ALL_Q_NAME =
            "DEPARTMENTS.ALL";
    public static final String DEPARTMENT_BY_NAME_Q_NAME =
            "DEPARTMENT.BY.NAME";

    public static final String SERVLET_MAPPING_VALUE = "/";
    public static final String APPLICATION_PROPERTIES_CLASSPATH =
            "classpath:application.properties";

    public static final String ENTITIES_PACKAGE = "com.aimprosoft.b.dubrovnyi.db";
    public static final String ENTITIES_PACKAGE_All = "com.aimprosoft.b.dubrovnyi.db.*";
    public static final String REPOSITORIES_PACKAGE = "com.aimprosoft.b.dubrovnyi.daos";
    public static final String CONTROLLERS_PACKAGE = "com.aimprosoft.b.dubrovnyi.controllers";
    public static final String ANNOTATIONS_PACKAGE = "com.aimprosoft.b.dubrovnyi.annotations";
    public static final String SERVICES_PACKAGE = "com.aimprosoft.b.dubrovnyi.services";
    public static final String VALIDATOR_PACKAGE = "com.aimprosoft.b.dubrovnyi.validator";
    public static final String PORTLET_PACKAGE = "com.aimprosoft.b.dubrovnyi.portlet";
    public static final String PERSISTENCE_XML_PATH = "META-INF/persistence.xml";


    public static final String PAGES_PATH = "/WEB-INF/pages/";
    public static final String PAGES_EXTENSION = ".jsp";

    //error messages
    public static final String DEPARTMENT_NAME_ERROR = "errorName";

    public static final String COOPERATOR_NAME_ERROR = "errorName";
    public static final String COOPERATOR_SURNAME_ERROR = "errorSurname";
    public static final String COOPERATOR_EMAIL_ERROR = "errorEmail";
    public static final String COOPERATOR_REG_DATE_ERROR = "errorRegDate";
}
