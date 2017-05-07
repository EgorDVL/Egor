package com.zhyzhko.controllers.forms;

import java.util.List;

/**
 * Created by Egor on 12.04.2017.
 */
public class ResponseCollectionShowForm {
    private int fieldId;
    private String fieldLabel;
    private String typeName;
    private List<String> typeValues;
    private boolean required;
    private boolean status;

    public ResponseCollectionShowForm() {
    }

    public ResponseCollectionShowForm(int fieldId, String fieldLabel, String typeName, List<String> typeValues, boolean required, boolean status) {
        this.fieldId = fieldId;
        this.fieldLabel = fieldLabel;
        this.typeName = typeName;
        this.typeValues = typeValues;
        this.required = required;
        this.status = status;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getTypeValues() {
        return typeValues;
    }

    public void setTypeValues(List<String> typeValues) {
        this.typeValues = typeValues;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseCollectionShowForm{" +
                "fieldId=" + fieldId +
                ", fieldLabel='" + fieldLabel + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeValues=" + typeValues +
                ", required=" + required +
                ", status=" + status +
                '}';
    }
}
