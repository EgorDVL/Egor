package com.zhyzhko.dao.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FieldResponse> fieldResponses;

    public Response() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FieldResponse> getFieldResponses() {
        return fieldResponses;
    }

    public void setFieldResponses(List<FieldResponse> fieldResponses) {
        this.fieldResponses = fieldResponses;
    }
    
}
