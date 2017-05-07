package db.rowmapper.impl;

import bean.Admin;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class AdminRowMapper implements RowMapper<Admin> {

    @Override
    public Admin extract(ResultSet set) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminId(set.getInt(1));
        admin.setName(set.getString(2));
        admin.setUserId(set.getInt(3));
        return admin;
    }
}