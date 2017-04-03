package db.dao;

import bean.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface AdminDAO {

    int createAdmin(Admin admin);

    Admin getAdminById(int adminId);

    List<Admin> getAllAdmins();

    boolean updateAdmin(Admin admin);

}
