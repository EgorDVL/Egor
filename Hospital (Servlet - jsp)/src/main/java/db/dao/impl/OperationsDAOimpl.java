package db.dao.impl;

import bean.Operation;
import bean.enums.OperationStatus;
import db.dao.OperationsDAO;
import db.rowmapper.impl.OperationsRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class OperationsDAOimpl implements OperationsDAO {
    private static final String CREATE_OPERATIONS = "insert into operations values(default, ?, ?, ?, ?)";
    private static final String GET_OPERATIONS_BY_ID = "select * from operations where operationsId = ?";
    private static final String GET_ALL_OPERATIONS = "select * from operations";
    private static final String GET_ALL_OPERATION_BY_STATUS = "select * from operations where status = ?";
    private static final String UPDATE_OPERATIONS = "update operations set name = ?, date = ?, complexity = ?, status = ? where operationsId = ?";
    private static final String UPDATE_OPERATION_STATUS = "update operations set status = ? where operationsId = ?";

    private JdbcTemplate<Operation> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createOperations(Operation operation) {

        return jdbcTemplate.create(CREATE_OPERATIONS, operation.getNameOperation(),
                new Date(operation.getDateOperation().getTime()),
                operation.getComplexityEnum().toString(),
                operation.getOperationStatus().toString());
    }

    @Override
    public Operation getOperationsById(int operationsId) {
        return jdbcTemplate.get(GET_OPERATIONS_BY_ID, new OperationsRowMapper(), operationsId);
    }

    @Override
    public List<Operation> getAllOperations() {
        return jdbcTemplate.getAll(GET_ALL_OPERATIONS, new OperationsRowMapper());
    }

    @Override
    public List<Operation> getAllOperationByStatus(OperationStatus operationStatus) {
        return jdbcTemplate.getAll(GET_ALL_OPERATION_BY_STATUS, new OperationsRowMapper(), operationStatus);
    }

    @Override
    public boolean updateOperations(Operation operation) {
        return jdbcTemplate.update(UPDATE_OPERATIONS, operation.getNameOperation(),
                new Date(operation.getDateOperation().getTime()), operation.getComplexityEnum().toString(),
                operation.getOperationStatus().toString(), operation.getOperationId());
    }

    @Override
    public boolean updateOperationsStatus(OperationStatus operationStatus, int operationId) {
        return jdbcTemplate.update(UPDATE_OPERATION_STATUS, operationStatus.toString(), operationId);
    }
}
