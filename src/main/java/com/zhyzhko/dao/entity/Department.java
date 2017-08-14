package com.zhyzhko.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhyzhko.util.validators.DepartmentVerification;
import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 06.07.17.
 */
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Length(min = 2, max = 15, message = "min length = 2, max length = 15")
    @MatchPattern(pattern = "^[\\p{L}]*$", message = "Incorrect input symbols")
    @NotNull(message = "Can't be null")
    @NotEmpty(message = "Fill in the field Name")
    @CheckWith(value = DepartmentVerification.class, message = "Department already exist")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employeeList;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
