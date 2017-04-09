package com.zhyzhko.dao.entity;

import javax.persistence.*;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class FieldResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responseId")
    private Response response;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fieldId")
    private Field field;

    private String value;

    public FieldResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
