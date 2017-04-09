package zhyzhko.spring.demo.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;

import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Egor on 24.02.2017.
 */
public class UserDto {
    private int id;

    @NotEmpty(message = "Field is empty")
    @Email
    private String email;

    @NotEmpty(message = "Field is empty")
    private String password;

    @NotEmpty(message = "Field is empty")
    @Size(min = 3, max = 15, message = "Your name must between 3 and 15 characters")
    private String name;

    @NotEmpty(message = "Field is empty")
    @Size(min = 3, max = 15, message = "Your Surname must between 3 and 15 characters")
    private String surname;

//    @NotEmpty(message = "Field is empty")
    private int groupId;
    private Set<RoleEnum> roles;

    public UserDto() {
    }

    public UserDto(int id, String email, String password, String name, String surname, int groupId, Set<RoleEnum> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
        this.roles = roles;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId=" + groupId +
                ", roles=" + roles +
                '}';
    }
}
