package util.validators;

import bean.Doctor;
import bean.Nurse;
import util.DateUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 01.02.2017.
 */
public class CreateNurseValidator {

    private static DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
    private static final String NAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String SURNAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String PHONE_REGEX = "[0-9]+";
    private static final String SPECIALITY_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String EXPIRIENCE_REGEX = "[0-9]+";


    public static boolean nonEmpty(Nurse nurse) {
        return nurse.getName() == null ||
                nurse.getName().isEmpty() ||
                nurse.getSurname() == null ||
                nurse.getSurname().isEmpty() ||
                nurse.getPhone() == null ||
                nurse.getPhone().isEmpty() ||
                nurse.getSpecialty() == null ||
                nurse.getSpecialty().isEmpty() ||
                nurse.getDateOfBirth() == null ||
                nurse.getExperience() == 0;
    }

    public static boolean validateForm(Nurse nurse) {
        return validateName(nurse.getName()) &&
                validateSurname(nurse.getSurname()) &&
                validatePhone(nurse.getPhone()) &&
                validateSpeciality(nurse.getSpecialty()) &&
                validateExperience(nurse.getExperience());
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