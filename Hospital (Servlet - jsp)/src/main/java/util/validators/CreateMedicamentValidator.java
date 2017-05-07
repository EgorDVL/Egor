package util.validators;

import bean.Medicament;

import java.util.Date;

/**
 * Created by Egor on 02.02.2017.
 */
public class CreateMedicamentValidator {

    public static boolean nonEmpty(Medicament medicament) {
        return medicament.getNameMedicament() == null || medicament.getNameMedicament().isEmpty() ||
                medicament.getUseMedicament() == null || medicament.getUseMedicament().isEmpty() ||
                medicament.getDateStartMedicament() == null ||
                medicament.getDateEndMedicament() == null;
    }

    public static boolean validateDate(Date dateStart, Date dateEnd) {
        return (dateStart.before(new Date()) || dateEnd.before(dateStart) || dateEnd.before(new Date()));
    }
}
