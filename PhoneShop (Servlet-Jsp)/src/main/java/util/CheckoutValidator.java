package util;

import web.form.CheckoutForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 28.10.2016.
 */
public class CheckoutValidator {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String NAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String SURNAME_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String PHONE_REGEX = "^\\+[1-9]{1}[0-9]{3,14}$";
    private static final String CITY_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String ADDRES_REGEX = "[A-Za-z]+|[А-Яа-я]+";
    private static final String HOUSE_REGEX = "[0-9]+";

    public static boolean nonEmptyCheckout(CheckoutForm checkoutForm) {
        return checkoutForm.getEmail() == null ||
                checkoutForm.getEmail().isEmpty() ||
                checkoutForm.getName() == null ||
                checkoutForm.getName().isEmpty() ||
                checkoutForm.getSurname() == null ||
                checkoutForm.getSurname().isEmpty() ||
                checkoutForm.getPhone() == null ||
                checkoutForm.getPhone().isEmpty() ||
                checkoutForm.getCity() == null ||
                checkoutForm.getCity().isEmpty() ||
                checkoutForm.getAddres() == null ||
                checkoutForm.getAddres().isEmpty() ||
                checkoutForm.getHouse() == 0;
    }

    public static boolean validateForm(CheckoutForm checkoutForm) {
        return validateEmail(checkoutForm.getEmail())
                && validateName(checkoutForm.getName())
                && validateSurname(checkoutForm.getSurname())
                && validatePhone(checkoutForm.getPhone())
                && validateCity(checkoutForm.getCity())
                && validateAddres(checkoutForm.getAddres())
                && validateHouse(checkoutForm.getHouse());
    }

    private static boolean validateEmail(String email) {
        Pattern patern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = patern.matcher(email);
        return matcher.matches();
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

    private static boolean validateCity(String city) {
        Pattern patern = Pattern.compile(CITY_REGEX);
        Matcher matcher = patern.matcher(city);
        return matcher.matches();
    }

    private static boolean validateAddres(String addres) {
        Pattern patern = Pattern.compile(ADDRES_REGEX);
        Matcher matcher = patern.matcher(addres);
        return matcher.matches();
    }

    private static boolean validateHouse(int house) {
        String houseStr = String.valueOf(house);
        Pattern patern = Pattern.compile(HOUSE_REGEX);
        Matcher matcher = patern.matcher(houseStr);
        return matcher.matches();
    }
}
