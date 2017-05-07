package util.validators;

import bean.Doctor;
import util.DateUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 01.02.2017.
 */
public class CreateDoctorValidator {
    private static DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
    private static final String NAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String SURNAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String PHONE_REGEX = "[0-9]+";
    private static final String SPECIALITY_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String EXPIRIENCE_REGEX = "[0-9]+";


    public static boolean nonEmpty(Doctor doctor) {
        return doctor.getName() == null ||
                doctor.getName().isEmpty() ||
                doctor.getSurname() == null ||
                doctor.getSurname().isEmpty() ||
                doctor.getPhone() == null ||
                doctor.getPhone().isEmpty() ||
                doctor.getSpecialty() == null ||
                doctor.getSpecialty().isEmpty() ||
                doctor.getDateOfBirth() == null ||
                doctor.getExperience() == 0;
    }

    public static boolean validateForm(Doctor doctor) {
        return validateName(doctor.getName()) &&
                validateSurname(doctor.getSurname()) &&
                validatePhone(doctor.getPhone()) &&
                validateSpeciality(doctor.getSpecialty()) &&
                validateExperience(doctor.getExperience());
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

    private static boolean validateSpeciality(String speciality) {
        Pattern patern = Pattern.compile(SPECIALITY_REGEX);
        Matcher matcher = patern.matcher(speciality);
        return matcher.matches();
    }

    private static boolean validateExperience(int experience) {
        String experienceStr = String.valueOf(experience);
        Pattern patern = Pattern.compile(EXPIRIENCE_REGEX);
        Matcher matcher = patern.matcher(experienceStr);
        return matcher.matches();
    }
}
