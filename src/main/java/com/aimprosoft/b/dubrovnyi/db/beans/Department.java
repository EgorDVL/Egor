package com.aimprosoft.b.dubrovnyi.db.beans;

import net.sf.oval.constraint.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import static com.aimprosoft.b.dubrovnyi.constants.ConstantClass.PRIME_NUMBER;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    private static final String DEPARTMENT_NAME_REG_EXP =
            "^[а-яА-Яa-zA-Z ]{5,29}+$";

    @Id
    @Column(name = "department_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name", nullable = false,
            length = 30)
//    @UniqueField(message = "There is already such name")
    @NotEmpty(message = "Name is empty")
    @Length(min = 5, max = 29, message = "Name should be from 5 to 29 symbols")
    @NotNull(message = "Name should not be null")
    @MatchPattern(
            pattern = DEPARTMENT_NAME_REG_EXP,
            message = "Wrong Name"
    )
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "department",
            orphanRemoval = true
    )
    @Cascade(
            value = {CascadeType.SAVE_UPDATE,
                    CascadeType.DELETE}
    )
    private List<Cooperator> cooperators;

    public Department() {
        //no operation
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Cooperator> getCooperators() {
        return cooperators;
    }

    public void setCooperators(List<Cooperator> cooperators) {
        this.cooperators = cooperators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Department anotherDepartment = (Department) o;

        return id == anotherDepartment.id
                && name.equals(anotherDepartment.name)
                && cooperators.equals(anotherDepartment.cooperators);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = PRIME_NUMBER * result + name.hashCode();
        result = PRIME_NUMBER * result + cooperators.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Department{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
