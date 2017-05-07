package db.dao.impl;

import bean.Admin;
import db.dao.AdminDAO;
import db.rowmapper.impl.AdminRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class AdminDAOimpl implements AdminDAO {

    private static final String CREATE_ADMIN = "insert into admin values(default, ?, ?)";
    private static final String GET_ADMIN_BY_ID = "select * from admin where adminId = ?";
    private static final String GET_ALL_ADMIN = "select * from admin";
    private static final String UPDATE_ADMIN = "update admin set name = ?, userId = ? where adminId = ?";

    private JdbcTemplate<Admin> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createAdmin(Admin admin) {
        return jdbcTemplate.create(CREATE_ADMIN,
                admin.getName(), admin.getUserId());
    }

    @Override
    public Admin getAdminById(int adminId) {
        return jdbcTemplate.get(GET_ADMIN_BY_ID, new AdminRowMapper(), adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return jdbcTemplate.getAll(GET_ALL_ADMIN, new AdminRowMapper());
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return jdbcTemplate.update(UPDATE_ADMIN, admin.getName(), admin.getUserId(), admin.getAdminId());
    }
}
