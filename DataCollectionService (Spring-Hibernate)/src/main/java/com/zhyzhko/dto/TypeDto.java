package com.zhyzhko.dto;

import com.zhyzhko.dao.entity.enums.TypeEnum;

/**
 * Created by Egor on 09.04.2017.
 */
public class TypeDto {
    private int id;
    private String typeName;

    public TypeDto() {
    }

    public TypeDto(String typeName) {
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeDto{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
