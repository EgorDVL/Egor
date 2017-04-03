package util;

import web.form.LoginForm;

/**
 * Created by Egor on 07.10.2016.
 */
public class LoginValidator {
    public static boolean nonEmptyCheck(LoginForm loginForm) {
        return loginForm.getEmail() == null || loginForm.getEmail().isEmpty()
                || loginForm.getPassword() == null || loginForm.getPassword().isEmpty();
    }
}
