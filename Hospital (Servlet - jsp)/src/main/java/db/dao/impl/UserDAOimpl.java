package db.dao.impl;

import bean.User;
import db.dao.UserDAO;
import db.rowmapper.impl.UserRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 09.01.2017.
 */
public class UserDAOimpl implements UserDAO {

    private static final String CREATE_USER = "insert into user values(default, ?, ?, ?)";
    private static final String GET_USER_BY_ID = "select * from user where userId = ?";
    private static final String GET_ALL_USER = "select * from user";
    private static final String UPDATE_USER = "update user set email = ?, password = ?, roleId = ? where userId = ?";
    private static final String GET_USER_BY_EMAIL = "select * from user where email = ?";
    private static final String DELETE_USER_BY_ID = "delete from `user` where userId = ?";

    private JdbcTemplate<User> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createUser(User user) {
        return jdbcTemplate.create(CREATE_USER,
                user.getEmail(), user.getPassword(), user.getUserRole().getValue());
    }

    @Override
    public User getUserById(int userId) {
        return jdbcTemplate.get(GET_USER_BY_ID, new UserRowMapper(), userId);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.getAll(GET_ALL_USER, new UserRowMapper());
    }

    @Override
    public boolean updateUser(User user) {
        return jdbcTemplate.update(UPDATE_USER,
                user.getEmail(), user.getPassword(), user.getUserRole().getValue(), user.getUserId());
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.get(GET_USER_BY_EMAIL, new UserRowMapper(), email);
    }

    @Override
    public boolean deleteUser(int userId) {
        return jdbcTemplate.delete(DELETE_USER_BY_ID, userId);
    }
}