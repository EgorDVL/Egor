package zhyzhko.bruteforce.test.task.bean;

/**
 * Created by Egor on 22.05.2017.
 */
public class Password {
    String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "password=" + password +
                '}';
    }
}
