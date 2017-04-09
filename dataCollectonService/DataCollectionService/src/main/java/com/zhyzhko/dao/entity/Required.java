package com.zhyzhko.dao.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class Required {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean value;

    @OneToMany(mappedBy = "required", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Field> fields;

    public Required() {
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

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
