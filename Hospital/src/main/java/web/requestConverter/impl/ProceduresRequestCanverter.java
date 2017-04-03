package web.requestConverter.impl;

import bean.Procedures;
import bean.enums.ProcedureStatus;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class ProceduresRequestCanverter implements HttpRequestConverter<Procedures> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Procedures fromRequest(HttpServletRequest req) {

        String nameProcedures = req.getParameter("name");
        String use = req.getParameter("use");
        Date dateStart = dateUtils.parse(req.getParameter("dateStart"));
        Date dateEnd = dateUtils.parse(req.getParameter("dateEnd"));

        ProcedureStatus procedureStatus = ProcedureStatus.getValue(req.getParameter("procedureStatus"));
        String proceduresId = req.getParameter("proceduresId");

        if (proceduresId != null) {
            int proceduresIdInt = Integer.parseInt(proceduresId);
            return new Procedures(proceduresIdInt, nameProcedures, use, dateStart, dateEnd, procedureStatus);
        }
        return new Procedures(nameProcedures, use, dateStart, dateEnd, procedureStatus);
    }
}
