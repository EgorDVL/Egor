package zhyzhko.spring.demo.dao.entity;

import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;
import zhyzhko.spring.demo.until.RoleConverter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Egor on 21.03.2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String name;
    private String surname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupId")
    private Groupp group;


    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Convert(converter = RoleConverter.class)
    @CollectionTable(name = "UserRole", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "roleId")
    private Set<RoleEnum> roles;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Groupp getGroup() {
        return group;
    }

    public void setGroup(Groupp group) {
        this.group = group;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" +

                "Groupp{" +
                "id=" + group.getId() +
                ", name='" + group.getName() + '\'' +
                ", countStudents=" + group.getCountStudents() +
                '}' + ", roles=" + roles +
                '}';
    }
}
