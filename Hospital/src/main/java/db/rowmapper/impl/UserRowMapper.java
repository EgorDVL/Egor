package db.rowmapper.impl;

import bean.User;
import bean.enums.UserRole;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 09.01.2017.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User extract(ResultSet set) throws SQLException {
        User user = new User();
        user.setUserId(set.getInt(1));
        user.setEmail(set.getString(2));
        user.setPassword(set.getString(3));
        user.setUserRole(UserRole.fromValue(set.getInt(4)));
        return user;
    }
}
