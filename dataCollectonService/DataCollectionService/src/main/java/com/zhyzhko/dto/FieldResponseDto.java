package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class FieldResponseDto {
    private int id;
    private int responseId;
    private int fieldId;
    private String value;

    public FieldResponseDto() {
    }

    public FieldResponseDto(int id, int responseId, int fieldId, String value) {
        this.id = id;
        this.responseId = responseId;
        this.fieldId = fieldId;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FieldResponseDto{" +
                "id=" + id +
                ", responseId=" + responseId +
                ", fieldId=" + fieldId +
                ", value='" + value + '\'' +
                '}';
    }
}
