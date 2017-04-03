package web.requestConverter.impl;

import bean.Healing;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class HealingRequestConverter implements HttpRequestConverter<Healing> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Healing fromRequest(HttpServletRequest req) {
        HttpSession session = req.getSession();

        String symptoms = (String) session.getAttribute("symptoms");//from CreateDiagnos
        Date dateStart = dateUtils.parse(req.getParameter("dateStart"));
        Date dateEnd = dateUtils.parse(req.getParameter("dateEnd"));
        int appointmentId = (int) session.getAttribute("appointmentId");
        int diagnosisId = (int) session.getAttribute("diagnosisId");
        int hospitalCardId = (int) session.getAttribute("hospitalCardIdForHealing");// from createHealing

        return new Healing(symptoms, dateStart, dateEnd, appointmentId, diagnosisId, hospitalCardId);
    }
}
