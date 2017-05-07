package util.validators;

import bean.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 10.01.2017.
 */
public class RegistrationValidator {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "[A-Za-z0-9!#$&]+";

    public static boolean nonEmptyCheck(User user) {
        return user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty();
    }

    public static boolean validateForm(User user) {
        return validateEmail(user.getEmail())
                && validatePassword(user.getPassword());
    }

    private static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
