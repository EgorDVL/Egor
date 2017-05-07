package util.validators;

/**
 * Created by Egor on 02.02.2017.
 */
public class CreateDiagnosisValidator {
    public static boolean nonEmptyCheck(String diagnosis, String symptoms) {
        return diagnosis == null || diagnosis.isEmpty()
                || symptoms == null || symptoms.isEmpty();
    }
}
