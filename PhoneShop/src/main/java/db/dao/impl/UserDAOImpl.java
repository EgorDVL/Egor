package db.dao.impl;

import bean.User;
import db.DBManager;
import db.dao.UserDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 23.09.2016.
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

    private static final String CREATE_USER = "insert into user values(default, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "update user set email = ?, password = ?, name = ?, surname = ?, phone=?, city=?, roleId = ? where userId = ?";
    private static final String GET_USER_BY_ID = "select userId, email, password, name, surname, phone, city, roleId from user where userId = ?";
    private static final String GET_USER_BY_EMAIL = "select userId , email, password, name, surname, phone, city, roleId from user where email= ?";
    private static final String GET_ALL_USERS = "select userId , email, password, name, surname, phone, city, roleId from user";


    @Override
    public int createUser(User user, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int result = -1;
        try {
            st = con.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getName());
            st.setString(4, user.getSurname());
            st.setString(5, user.getPhone());
            st.setString(6, user.getCity());
            st.setInt(7, user.getRoleId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Can't create new User");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return result;
    }

    @Override
    public User getUserById(int userId, Connection con) throws SQLException {
        User user = null;
        PreparedStatement st = null;
        ResultSet set = null;
        try {
            st = con.prepareStatement(GET_USER_BY_ID);
            st.setInt(1, userId);
            set = st.executeQuery();
            while (set.next()) {
                user = new User();
                user.setUserId(set.getInt(1));
                user.setEmail(set.getString(2));
                user.setPassword(set.getString(3));
                user.setName(set.getString(4));
                user.setSurname(set.getString(5));
                user.setPhone(set.getString(6));
                user.setCity(set.getString(7));
                user.setRoleId(set.getInt(8));
            }
        } catch (SQLException e) {
            LOG.error("Can't get user by Id");
            throw e;
        } finally {
            DBManager.closeRs(set);
            DBManager.closeStat(st);
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email, Connection con) throws SQLException {
        User user = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_USER_BY_EMAIL);
            st.setString(1, email);
            rs = st.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
                user.setSurname(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setCity(rs.getString(7));
                user.setRoleId(rs.getInt(8));
            }
        } catch (SQLException e) {
            LOG.error("Can't get user by email");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(Connection con) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_ALL_USERS);
            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
                user.setSurname(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setCity(rs.getString(7));
                user.setRoleId(rs.getInt(8));
                userList.add(user);
            }
        } catch (SQLException e) {
            LOG.error("Can't get all users");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return userList;
    }

    @Override
    public boolean updateUser(User user, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(UPDATE_USER);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getName());
            st.setString(4, user.getSurname());
            st.setString(5, user.getPhone());
            st.setString(6, user.getCity());
            st.setLong(7, user.getRoleId());
            st.setInt(8, user.getUserId());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't update user");
            throw e;
        } finally {
            DBManager.closeRs(rs);
            DBManager.closeStat(st);
        }
        return true;
    }
}
