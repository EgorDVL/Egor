package db.rowmapper.impl;

import bean.Operation;
import bean.enums.ComplexityEnum;
import bean.enums.OperationStatus;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class OperationsRowMapper implements RowMapper<Operation> {
    @Override
    public Operation extract(ResultSet set) throws SQLException {
        Operation operation = new Operation();
        operation.setOperationId(set.getInt(1));
        operation.setNameOperation(set.getString(2));
        operation.setDateOperation(set.getDate(3));
        operation.setComplexityEnum(ComplexityEnum.getValue(set.getString(4)));
        operation.setOperationStatus(OperationStatus.getValue(set.getString(5)));
        return operation;
    }
}
