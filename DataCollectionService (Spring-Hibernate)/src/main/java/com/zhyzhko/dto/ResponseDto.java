package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class ResponseDto {
    private int id;

    public ResponseDto() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "id=" + id +
                '}';
    }
}
