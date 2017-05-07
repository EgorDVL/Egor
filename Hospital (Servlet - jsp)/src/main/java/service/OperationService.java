package service;

import bean.Operation;
import bean.enums.OperationStatus;

/**
 * Created by Egor on 22.01.2017.
 */
public interface OperationService {

    boolean updateOperation(Operation operation);

    int createOperation(Operation operation);

    Operation getOperationById(int operationId);

    boolean executeOperation(int operationId);
}
