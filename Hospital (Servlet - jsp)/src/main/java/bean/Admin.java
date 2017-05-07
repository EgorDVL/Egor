package bean;

/**
 * Created by Egor on 05.01.2017.
 */
public class Admin {

    private int adminId;
    private String name;
    private int userId;

    public Admin() {
    }

    public Admin(int adminId, String name, int userId) {
        this.adminId = adminId;
        this.name = name;
        this.userId = userId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
