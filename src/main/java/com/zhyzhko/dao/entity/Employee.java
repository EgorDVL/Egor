package com.zhyzhko.dao.entity;

import com.zhyzhko.util.validators.EmployeeVerification;
import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 06.07.17.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 2, max = 15, message = "Name must be min length = 2, max length = 15")
    @MatchPattern(pattern = "^[a-zA-Z]*$", message = "Incorrect input symbols")
    @NotNull(message = "Can't be null")
    @NotEmpty(message = "Fill in the field Name")
    private String name;

    @Length(min = 2, max = 15, message = "Surname must be min length = 2, max length = 15")
    @MatchPattern(pattern = "^[a-zA-Z]*$", message = "Incorrect input symbols")
    @NotNull(message = "Can't be null")
    @NotEmpty(message = "Fill in the field Surname")
    private String surname;

    @NotNegative(message = "Experience can't be negative")
    @NotEmpty(message = "Fill in the field Experience")
    private Integer experience;

    @Email(message = "Incorrect email field")
    @NotEmpty(message = "Fill in the field Email")
    @CheckWith(value = EmployeeVerification.class, message = "Email already exist")
    private String email;


    @NotEmpty(message = "Incorrect date field")
    @NotNull(message = "Fill in the field Date")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;

    public Employee() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", department=" + "Department{" +
                "id=" + department.getId() +
                ", name='" + department.getName() +
                '}';
    }
}