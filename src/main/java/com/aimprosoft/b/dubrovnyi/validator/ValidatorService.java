package com.aimprosoft.b.dubrovnyi.validator;

import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
import com.aimprosoft.b.dubrovnyi.db.beans.Department;
import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.*;

@Component
public class ValidatorService {
    private DepartmentService departmentSpringService;

    private CooperatorService cooperatorSpringService;

    @Autowired
    public ValidatorService(DepartmentService departmentSpringService,
                            CooperatorService cooperatorSpringService) {

        this.departmentSpringService = departmentSpringService;
        this.cooperatorSpringService = cooperatorSpringService;
    }

    private static final String DATE_FORMAT_REG_EXP =
            "^[0-9]{4}-+[01]{1}+[0-9]{1}-+[0-3]{1}+[0-9]{1}+$";
    private static final String DATE_SPLIT = "-";
    private static final String FEBRUARY_IN_DIGIT = "02";

    public Map<String, String> getCooperatorErrorMap(
            Cooperator cooperator, String dateInStringFormat,
            boolean isEditMode, String oldCooperatorEmail) {


        Map<String, String> errorMap = new LinkedHashMap<>();
        Validator validator = new Validator();

        if (!isDateValid(dateInStringFormat)) {
            errorMap.put(COOPERATOR_REG_DATE_ERROR, "Wrong Date");
        }

        List<ConstraintViolation> currentFieldConstraints;

        try {
            Field nameField = cooperator.getClass().getDeclaredField("name");
            Field surnameField = cooperator.getClass().getDeclaredField("surname");
            Field emailField = cooperator.getClass().getDeclaredField("email");


            currentFieldConstraints = validator.validateFieldValue(cooperator,
                    nameField, cooperator.getName());

            putErrorIfNecessary(currentFieldConstraints, errorMap,
                    COOPERATOR_NAME_ERROR);


            currentFieldConstraints = validator.validateFieldValue(cooperator,
                    surnameField, cooperator.getSurname());

            putErrorIfNecessary(currentFieldConstraints, errorMap,
                    COOPERATOR_SURNAME_ERROR);


            final boolean isTheSameValue =
                    isTheSameEntity(cooperator.getEmail(), oldCooperatorEmail);

            currentFieldConstraints = validator.validateFieldValue(cooperator,
                    emailField, cooperator.getEmail());
            putErrorIfNecessary(currentFieldConstraints, errorMap,
                    COOPERATOR_EMAIL_ERROR, cooperator,
                    cooperator.getEmail(), isEditMode, isTheSameValue);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Check your field name: ", e);
        }

        return errorMap;
    }

    public Map<String, String> getDepartmentErrorMap(
            Department department, boolean isEditMode, String oldDepartmentName) {

        Map<String, String> errorMap = new LinkedHashMap<>();
        Validator validator = new Validator();

        List<ConstraintViolation> currentFieldConstraints;

        try {
            Field nameField = department.getClass().getDeclaredField("name");

            currentFieldConstraints = validator.validateFieldValue(
                    department, nameField, department.getName());

            final boolean isTheSameValue =
                    isTheSameEntity(department.getName(), oldDepartmentName);

            putErrorIfNecessary(currentFieldConstraints, errorMap,
                    DEPARTMENT_NAME_ERROR, department,
                    department.getName(), isEditMode, isTheSameValue);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Check your field name: ", e);
        }

        return errorMap;
    }

    private boolean isTheSameEntity(String currentValue, String oldValue) {
        //do not simplify it:
        if (currentValue == null || oldValue == null) {
            return false;
        }

        return currentValue.equals(oldValue);
    }

    private void putErrorIfNecessary(List<ConstraintViolation> currentFieldConstraint,
                                     Map<String, String> errorMap, String fieldErrorName) {

        if (!currentFieldConstraint.isEmpty()) {
            errorMap.put(fieldErrorName,
                    currentFieldConstraint.get(0).getMessage());
        }
    }

    private void putErrorIfNecessary(List<ConstraintViolation> currentFieldConstraint,
                                     Map<String, String> errorMap, String fieldErrorName,
                                     Object entity, String entityField,
                                     boolean isEditMode, boolean sameValue) {

        final boolean isUniqueErrorFieldName =
                DEPARTMENT_NAME_ERROR.equals(fieldErrorName)
                        || COOPERATOR_EMAIL_ERROR.equals(fieldErrorName);

        if (isUniqueErrorFieldName && !(isEditMode && sameValue)) {

            //set error if presents, if not set - return;
            if (isSetNotUniqueErrorMessage(errorMap, fieldErrorName,
                    entity, entityField)) {
                return;
            }
        }

        //if does not set:
        putErrorIfNecessary(currentFieldConstraint, errorMap, fieldErrorName);
    }

    private boolean isSetNotUniqueErrorMessage(Map<String, String> errorMap,
                                               String fieldErrorName,
                                               Object entity,
                                               String entityField) {

        if (entity instanceof Department) {
            final boolean isUnique = isDepartmentUnique(entityField);

            return putNotUniqueMessageIfNecessary(isUnique, errorMap,
                    fieldErrorName, "There is already such name");
        }

        if (entity instanceof Cooperator) {
            final boolean isUnique = isCooperatorUnique(entityField);

            return putNotUniqueMessageIfNecessary(isUnique, errorMap,
                    fieldErrorName, "There is already such email");
        }

        throw new RuntimeException("This Service is not support "
                + entity.getClass().getName() + " class");

    }


    private boolean putNotUniqueMessageIfNecessary(boolean isUnique,
                                                   Map<String, String> errorMap,
                                                   String errorKey,
                                                   String errorMessage) {
        if (isUnique) {
            return false;
        }

        errorMap.put(errorKey, errorMessage);
        return true;
    }

    private boolean isDepartmentUnique(String departmentName) {
        return departmentSpringService.getDepartment(departmentName) == null;
    }

    private boolean isCooperatorUnique(String cooperatorEmail) {
        return cooperatorSpringService.getCooperator(cooperatorEmail) == null;
    }


    private void putSpecialErrorMessage(
            List<ConstraintViolation> currentConstraint,
            Map<String, String> errorMap, String key) {


        if (currentConstraint.size() > 1) {
            errorMap.put(key, currentConstraint.get(1).getMessage());
        }
    }

    private boolean isDateValid(String dateString) {
        if (!checkString(dateString, DATE_FORMAT_REG_EXP)) {
            return false;
        }

        String[] dateComposites = dateString.split(DATE_SPLIT);
        String month = dateComposites[1];
        if (!isRightMonthFormat(month)) {
            return false;
        }

        String day = dateComposites[2];
        return isRightDayFormat(day, month);
    }

    private boolean checkString(String inputString, String regularExpression) {
        if (inputString != null) {
            Pattern pa = Pattern.compile(regularExpression);
            Matcher m = pa.matcher(inputString);
            return m.find();
        }
        return false;
    }

    private boolean isRightMonthFormat(String monthString) {
        if (monthString.startsWith("0")) {
            return !monthString.endsWith("0");
        }
        return monthString.endsWith("0") || monthString.endsWith("1") || monthString.endsWith("2");
    }

    private boolean isRightDayFormat(String dayString, String monthString) {
        if (dayString.startsWith("0")) {
            return !dayString.endsWith("0");
        }
        if (FEBRUARY_IN_DIGIT.equals(monthString)) {
            return !dayString.startsWith("3");
        }         // do not simplify this statement

        if (dayString.startsWith("3")) {
            return dayString.endsWith("0") || dayString.endsWith("1");
        }
        return true;
    }
}
