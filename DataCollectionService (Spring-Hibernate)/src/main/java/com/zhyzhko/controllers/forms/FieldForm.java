package com.zhyzhko.controllers.forms;

/**
 * Created by Egor on 11.04.2017.
 */
public class FieldForm {
    private int id;
    private String label;
    private String type;
    private boolean required;
    private boolean status;
    private String typeValue;

    public FieldForm() {
    }

    public FieldForm(int id, String label, String type, boolean required, boolean status, String typeValue) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.required = required;
        this.status = status;
        this.typeValue = typeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

}
