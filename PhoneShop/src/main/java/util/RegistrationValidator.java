package util;

import web.form.RegistrationForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 09.10.2016.
 */
public class RegistrationValidator {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "[A-Za-z0-9!#$&]+";
    private static final String NAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String SURNAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String PHONE_REGEX = "^\\+[1-9]{1}[0-9]{3,14}$";

    public static boolean nonEmptyCheckRegistration(RegistrationForm registrationForm) {
        return registrationForm.getEmail() == null ||
                registrationForm.getPassword() == null ||
                registrationForm.getName() == null ||
                registrationForm.getSurname() == null ||
                registrationForm.getEmail().isEmpty() ||
                registrationForm.getPassword().isEmpty() ||
                registrationForm.getName().isEmpty() ||
                registrationForm.getSurname().isEmpty() ||
                registrationForm.getPhone() == null ||
                registrationForm.getPhone().isEmpty();
    }

    public static boolean validateForm(RegistrationForm registrationForm) {
        return validateEmail(registrationForm.getEmail())
                && validatePassword(registrationForm.getPassword())
                && validateName(registrationForm.getName())
                && validateSurName(registrationForm.getSurname())
                && validatePhone(registrationForm.getPhone());
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

    private static boolean validateName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean validateSurName(String surName) {
        Pattern pattern = Pattern.compile(SURNAME_REGEX);
        Matcher matcher = pattern.matcher(surName);
        return matcher.matches();
    }

    private static boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
