package web.requestConverter.impl;

import bean.Medicament;
import bean.Operation;
import bean.enums.MedicamentEnum;
import bean.enums.MedicamentStatus;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class MedicamentRequestConverter implements HttpRequestConverter<Medicament> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Medicament fromRequest(HttpServletRequest req) {

        String nameMedicament = req.getParameter("name");
        MedicamentEnum type = MedicamentEnum.getValue(req.getParameter("type"));
        String use = req.getParameter("use");
        Date dateStart = dateUtils.parse(req.getParameter("dateStart"));
        Date dateEnd = dateUtils.parse(req.getParameter("dateEnd"));
        MedicamentStatus medicamentStatus = MedicamentStatus.getValue(req.getParameter("medicamentStatus"));

        String medicamentId = req.getParameter("medicamentId");

        if (medicamentId != null) {
            int medicamentIdInt = Integer.parseInt(medicamentId);
            return new Medicament(medicamentIdInt, nameMedicament, type, use, dateStart, dateEnd, medicamentStatus);
        }
        return new Medicament(nameMedicament, type, use, dateStart, dateEnd, medicamentStatus);
    }
}
