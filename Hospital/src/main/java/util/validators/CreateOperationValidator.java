package util.validators;

import bean.Operation;

import java.util.Date;

/**
 * Created by Egor on 02.02.2017.
 */
public class CreateOperationValidator {

    public static boolean nonEmpty(Operation operation) {
        return operation.getNameOperation() == null || operation.getNameOperation().isEmpty() ||
                operation.getDateOperation() == null;
    }

    public static boolean validateDate(Date dateOperation) {
        return (dateOperation.before(new Date()));
    }
}
