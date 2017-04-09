package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class TypeValueDto {
    private int id;
    private String value;
    private int typeId;

    public TypeValueDto() {
    }

    public TypeValueDto(int id, String value, int typeId) {
        this.id = id;
        this.value = value;
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "TypeValueDto{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
