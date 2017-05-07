package web.requestConverter.impl;

import bean.Appointment;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Egor on 16.01.2017.
 */
public class AppointmentRequestConverter implements HttpRequestConverter<Appointment> {

    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Appointment fromRequest(HttpServletRequest req) {
        HttpSession session = req.getSession();

        Appointment appointment = new Appointment();

        String nameAppointment = req.getParameter("name");
        appointment.setNameAppointment(nameAppointment);

        String currentDate = dateUtils.format(new Date());
        Date date = dateUtils.parse(currentDate);
        appointment.setDateAppointment(date);

        String operationId = (String) session.getAttribute("operationId");
        String medicamentId = (String) session.getAttribute("medicamentId");
        String proceduresId = (String) session.getAttribute("proceduresId");

        if (operationId != null) {
            appointment.setOperationId(Integer.parseInt(operationId));
        }
        if (medicamentId != null) {
            appointment.setMedicamentId(Integer.parseInt(medicamentId));
        }
        if (proceduresId != null) {
            appointment.setProceduresId(Integer.parseInt(proceduresId));
        }

        return appointment;
    }
}
