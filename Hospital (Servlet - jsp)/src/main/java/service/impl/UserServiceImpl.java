package service.impl;

import bean.User;
import bean.enums.UserRole;
import db.dao.UserDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.UserService;

/**
 * Created by Egor on 09.01.2017.
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int createUser(String email, String password, UserRole userRole) {
        User user = new User(email, password, userRole);
        try {
            return userDAO.createUser(user);
        } catch (PersistException e) {
            LOG.error("Can't create User", e);
            throw new ServiceException("Can't create User");
        }
    }

    public User getUserById(int userId) {
        try {
            return userDAO.getUserById(userId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get User by id", e);
            throw new ServiceException("Can't get User by Id");
        }
    }

    public User getUserByEmail(String email) {
        try {
            return userDAO.getUserByEmail(email);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get User by email", e);
            throw new ServiceException("Can't get User id by Email", e);
        }
    }

    @Override
    public boolean deleteUserById(int userId) {
        try {
            return userDAO.deleteUser(userId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete User by id", e);
            throw new ServiceException("Can't delete User by id", e);
        }
    }
}
