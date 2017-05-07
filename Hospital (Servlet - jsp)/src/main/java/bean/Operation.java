package bean;

import bean.enums.ComplexityEnum;
import bean.enums.OperationStatus;

import java.util.Date;

/**
 * Created by Egor on 05.01.2017.
 */
public class Operation {
    private int operationId;
    private String nameOperation;
    private Date dateOperation;
    private ComplexityEnum complexityEnum;
    private OperationStatus operationStatus;

    public Operation() {
    }

    public Operation(String nameOperation, Date dateOperation, ComplexityEnum complexityEnum, OperationStatus operationStatus) {
        this.nameOperation = nameOperation;
        this.dateOperation = dateOperation;
        this.complexityEnum = complexityEnum;
        this.operationStatus = operationStatus;
    }

    public Operation(int operationId, String nameOperation, Date dateOperation, ComplexityEnum complexityEnum, OperationStatus operationStatus) {
        this(nameOperation, dateOperation, complexityEnum, operationStatus);
        this.operationId = operationId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public ComplexityEnum getComplexityEnum() {
        return complexityEnum;
    }

    public void setComplexityEnum(ComplexityEnum complexityEnum) {
        this.complexityEnum = complexityEnum;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", nameOperation='" + nameOperation + '\'' +
                ", dateOperation=" + dateOperation +
                ", complexityEnum=" + complexityEnum +
                ", operationStatus=" + operationStatus +
                '}';
    }
}
