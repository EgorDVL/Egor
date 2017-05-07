package com.zhyzhko.dao.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private Ttype typeField;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requiredId")
    private Required required;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId")
    private Status status;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldResponse> fieldResponses;

    public Field() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Ttype getTypeField() {
        return typeField;
    }

    public void setTypeField(Ttype typeField) {
        this.typeField = typeField;
    }

    public Required getRequired() {
        return required;
    }

    public void setRequired(Required required) {
        this.required = required;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<FieldResponse> getFieldResponses() {
        return fieldResponses;
    }

    public void setFieldResponses(Set<FieldResponse> fieldResponses) {
        this.fieldResponses = fieldResponses;
    }
}
