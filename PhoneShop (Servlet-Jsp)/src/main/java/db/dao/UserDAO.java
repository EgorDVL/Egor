package db.dao;

import bean.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public interface UserDAO {

    int createUser(User user, Connection con) throws SQLException;

    User getUserById(int userId, Connection con) throws SQLException;

    User getUserByEmail(String email, Connection con) throws SQLException;

    List<User> getAllUsers(Connection con) throws SQLException;

    boolean updateUser(User user, Connection con) throws SQLException;
}
