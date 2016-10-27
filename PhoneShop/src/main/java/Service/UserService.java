package Service;

import bean.User;
import db.DBManager;
import db.dao.DaoFactory;
import db.dao.UserDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Egor on 07.10.2016.
 */
public class UserService {
    private static final Logger LOG = Logger.getLogger(UserService.class);
    private UserDAO userDao = DaoFactory.getUserDAO();

    public boolean createUser(String email, String password, String name, String surname, String phone, int roleId) {
        Connection con = DBManager.getConnection();
        User user = new User(email, password, name, surname, phone, roleId);
        boolean result = false;
        try {
            result = userDao.createUser(user, con) != -1;
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't create new User");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return result;
    }

    public User getUserByEmail(String email) {
        Connection con = DBManager.getConnection();
        User user = null;
        try {
            user = userDao.getUserByEmail(email, con);
            DBManager.commit(con);
        } catch (SQLException e) {
            LOG.error("Can't get User by email");
            DBManager.rollback(con);
        } finally {
            DBManager.closeCon(con);
        }
        return user;
    }
}
