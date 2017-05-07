package com.zhyzhko.dao.entity;

import javax.persistence.*;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class TypeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private Ttype typeValue;

    public TypeValue() {
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

    public Ttype getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Ttype typeValue) {
        this.typeValue = typeValue;
    }
}
