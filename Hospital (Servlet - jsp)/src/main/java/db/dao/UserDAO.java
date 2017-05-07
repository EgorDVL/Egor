package db.dao;

import bean.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Egor on 09.01.2017.
 */
public interface UserDAO {
    int createUser(User user);

    User getUserById(int userId);

    List<User> getAllUsers();

    boolean updateUser(User user);

    User getUserByEmail(String email);

    boolean deleteUser(int userId);
}
