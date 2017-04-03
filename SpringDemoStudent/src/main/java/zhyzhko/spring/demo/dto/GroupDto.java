package zhyzhko.spring.demo.dto;

/**
 * Created by Egor on 24.02.2017.
 */
public class GroupDto {
    private int id;
    private String name;
    private int countStudents;

    public GroupDto() {
    }

    public GroupDto(int id, String name, int countStudents) {
        this.id = id;
        this.name = name;
        this.countStudents = countStudents;
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

    @Override
    public String toString() {
        return "GroupDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countStudents=" + countStudents +
                '}';
    }
}
