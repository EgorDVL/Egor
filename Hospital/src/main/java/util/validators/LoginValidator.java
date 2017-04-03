package util.validators;

import bean.User;

/**
 * Created by Egor on 07.10.2016.
 */
public class LoginValidator {
    public static boolean nonEmptyCheck(User user) {
        return user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty();
    }
}
