package com.zhyzhko.models;

import com.zhyzhko.util.validators.DepartmentVerification;
import net.sf.oval.constraint.*;

/**
 * Created by user on 03.07.17.
 */
public class Department {

    private int id;

    @Length(min = 2, max = 15, message = "min length = 2, max length = 15")
    @NotNull(message = "Can't be null")
    @NotEmpty(message = "Fill in the field Name")
    @CheckWith(value = DepartmentVerification.class, message = "Department already exist")
    private String name;


    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
