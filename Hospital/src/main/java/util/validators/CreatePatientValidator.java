package util.validators;

import bean.Doctor;
import bean.Patient;
import util.DateUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 01.02.2017.
 */
public class CreatePatientValidator {
    private static DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
    private static final String NAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String SURNAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String PHONE_REGEX = "^[0-9]+";

    public static boolean nonEmpty(Patient patient) {
        return patient.getName() == null ||
                patient.getName().isEmpty() ||
                patient.getSurname() == null ||
                patient.getSurname().isEmpty() ||
                patient.getPhone() == null ||
                patient.getPhone().isEmpty() ||
                patient.getDateOfBirth() == null ||
                patient.getAddress() == null ||
                patient.getAddress().isEmpty();
    }

    public static boolean validateForm(Patient patient) {
        return validateName(patient.getName()) &&
                validateSurname(patient.getSurname()) &&
                validatePhone(patient.getPhone());
    }

    public static boolean validateDate(Date dateOfBirth) {
        return (dateOfBirth.after(new Date()) || dateOfBirth.before(dateUtils.parse("1917-01-01")));
    }

    private static boolean validateName(String name) {
        Pattern patern = Pattern.compile(NAME_REGEX);
        Matcher matcher = patern.matcher(name);
        return matcher.matches();
    }

    private static boolean validateSurname(String surname) {
        Pattern patern = Pattern.compile(SURNAME_REGEX);
        Matcher matcher = patern.matcher(surname);
        return matcher.matches();
    }

    private static boolean validatePhone(String phone) {
        Pattern patern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = patern.matcher(phone);
        return matcher.matches();
    }
}
