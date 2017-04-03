package service;

import bean.User;
import bean.enums.UserRole;

/**
 * Created by Egor on 22.01.2017.
 */
public interface UserService {

    int createUser(String email, String password, UserRole userRole);

    User getUserById(int userId);

    User getUserByEmail(String email);

    boolean deleteUserById(int userId);
}
