package zhyzhko.spring.demo.dao.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Egor on 21.03.2017.
 */
@Entity
public class Groupp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int countStudents;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> users;

    public Groupp() {
    }

    public Groupp(String name, int countStudents, List<User> users) {
        this.name = name;
        this.countStudents = countStudents;
        this.users = users;
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

    public int getCountStudents() {
        return countStudents;
    }

    public void setCountStudents(int countStudents) {
        this.countStudents = countStudents;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Groupp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countStudents=" + countStudents +
                ", users=" + users +
                '}';
    }
}
