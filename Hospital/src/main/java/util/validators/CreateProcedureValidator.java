package util.validators;

import bean.Procedures;

import java.util.Date;

/**
 * Created by Egor on 02.02.2017.
 */
public class CreateProcedureValidator {
    public static boolean nonEmpty(Procedures procedures) {
        return procedures.getNameProcedure() == null || procedures.getNameProcedure().isEmpty() ||
                procedures.getUseProcedure() == null || procedures.getUseProcedure().isEmpty() ||
                procedures.getDateStartProcedure() == null ||
                procedures.getDateEndProcedure() == null;
    }

    public static boolean validateDate(Date dateStart, Date dateEnd) {
        return (dateStart.before(new Date()) || dateEnd.before(dateStart) || dateEnd.before(new Date()));
    }
}
