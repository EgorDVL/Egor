package com.zhyzhko.dao.entity;

import com.zhyzhko.dao.entity.enums.TypeEnum;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class Ttype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeEnum typeName;

    @OneToMany(mappedBy = "typeField", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Field> fields;

    @OneToMany(mappedBy = "typeValue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TypeValue> values;

    public Ttype() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeEnum getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeEnum typeName) {
        this.typeName = typeName;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public Set<TypeValue> getValues() {
        return values;
    }

    public void setValues(Set<TypeValue> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Ttype{" +
                "id=" + id +
//                ", typeName=" + typeName +
//                ", fields=" + fields +
//                ", values=" + values +
                '}';
    }
}
