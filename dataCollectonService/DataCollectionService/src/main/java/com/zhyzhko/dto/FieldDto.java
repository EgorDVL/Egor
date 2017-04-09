package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class FieldDto {
    private int id;
    private String lable;
    private int typeId;
    private int requiredId;
    private int statusId;

    public FieldDto() {
    }

    public FieldDto(int id, String lable, int typeId, int requiredId, int statusId) {
        this.id = id;
        this.lable = lable;
        this.typeId = typeId;
        this.requiredId = requiredId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getRequiredId() {
        return requiredId;
    }

    public void setRequiredId(int requiredId) {
        this.requiredId = requiredId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "FieldDto{" +
                "id=" + id +
                ", lable='" + lable + '\'' +
                ", typeId=" + typeId +
                ", requiredId=" + requiredId +
                ", statusId=" + statusId +
                '}';
    }
}
