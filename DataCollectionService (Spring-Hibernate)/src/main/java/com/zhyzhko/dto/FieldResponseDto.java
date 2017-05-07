package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class FieldResponseDto {
    private int id;
    private int responseId;
    private FieldDto field;
    private String value;

    public FieldResponseDto() {
    }

    public FieldResponseDto(int responseId, FieldDto field, String value) {
        this.responseId = responseId;
        this.field = field;
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

    public FieldDto getField() {
        return field;
    }

    public void setField(FieldDto field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldResponseDto that = (FieldResponseDto) o;

        if (id != that.id) return false;
        if (responseId != that.responseId) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + responseId;
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FieldResponseDto{" +
                "id=" + id +
                ", responseId=" + responseId +
                ", field=" + field +
                ", value='" + value + '\'' +
                '}';
    }
}
