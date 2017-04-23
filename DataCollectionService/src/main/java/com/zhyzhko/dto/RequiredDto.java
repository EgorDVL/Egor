package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class RequiredDto {
    private int id;
    private boolean value;

    public RequiredDto() {
    }

    public RequiredDto(int id, boolean value) {
        this.id = id;
        this.value = value;
    }

    public RequiredDto(boolean value) {
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
        return "RequiredDto{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
