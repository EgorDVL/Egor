package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class StatusDto {
    private int id;
    private boolean value;

    public StatusDto() {
    }

    public StatusDto(int id, boolean value) {
        this.id = id;
        this.value = value;
    }

    public StatusDto(boolean value) {
        this.value = value;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
