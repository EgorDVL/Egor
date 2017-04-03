package db.dao;

import bean.Operation;
import bean.enums.OperationStatus;

import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface OperationsDAO {
    int createOperations(Operation operation);

    Operation getOperationsById(int operationId);

    List<Operation> getAllOperations();

    List<Operation> getAllOperationByStatus(OperationStatus operationStatus);

    boolean updateOperations(Operation operation);

    boolean updateOperationsStatus(OperationStatus operationStatus, int operationId);
}
