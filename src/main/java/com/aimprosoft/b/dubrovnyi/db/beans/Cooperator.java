package com.aimprosoft.b.dubrovnyi.db.beans;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.PRIME_NUMBER;

@Entity
@Table(name = "cooperator")
public class Cooperator implements Serializable {
    private static final String COOPERATOR_NAME_REG_EXP = "^[а-яА-Яa-zA-Z]{5,19}+$";
    private static final String EMAIL_REG_EXP = "^.+@.+[.].{2,39}+$";

    @Id
    @Column(name = "cooperator_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cooperator_name", nullable = false,
            length = 20)
    @NotEmpty(message = "Name is empty")
    @Length(min = 5, max = 19,
            message = "Name should be from 5 to 19 symbols")
    @NotNull(message = "Name should not be null")
    @MatchPattern(
            pattern = COOPERATOR_NAME_REG_EXP,
            message = "Wrong Name"
    )
    private String name;

    @Column(name = "cooperator_surname", nullable = false,
            length = 20)
    @NotEmpty(message = "Surname is empty")
    @Length(min = 5, max = 19,
            message = "Surname should be from 5 to 19 symbols")
    @NotNull(message = "Surname should not be null")
    @MatchPattern(
            pattern = COOPERATOR_NAME_REG_EXP,
            message = "Wrong Surname"
    )
    private String surname;

    @Column(name = "cooperator_email", nullable = false,
            unique = true, length = 45)
//    @UniqueField(message = "There is already such email")
    @NotEmpty(message = "Email is empty")
    @NotNull(message = "Email should not be null")
    @MatchPattern(
            pattern = EMAIL_REG_EXP,
            message = "Wrong Email"
    )
    private String email;

    @Column(name = "cooperator_registration_data")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date registrationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dep")
    private Department department;

    public Cooperator() {
        //no operation
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object comparableObject) {
        if (this == comparableObject) {
            return true;
        }
        if (comparableObject == null
                || getClass() != comparableObject.getClass()) {
            return false;
        }

        Cooperator anotherCooperator = (Cooperator) comparableObject;

        boolean isPersonalInformationAreEqual = name.equals(anotherCooperator.name)
                && surname.equals(anotherCooperator.surname)
                && email.equals(anotherCooperator.email);

        return id == anotherCooperator.id && isPersonalInformationAreEqual
                && registrationDate.equals(anotherCooperator.registrationDate)
                && department.equals(anotherCooperator.department);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = PRIME_NUMBER * result + name.hashCode();
        result = PRIME_NUMBER * result + surname.hashCode();
        result = PRIME_NUMBER * result + email.hashCode();
        result = PRIME_NUMBER * result + registrationDate.hashCode();
        result = PRIME_NUMBER * result + department.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cooperator{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", email='" + email + '\''
                + ", registrationDate=" + registrationDate
                + ", department=" + department
                + '}';
    }
}