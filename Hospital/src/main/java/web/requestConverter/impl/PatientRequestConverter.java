package web.requestConverter.impl;

import bean.Patient;
import bean.enums.PatientStatus;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class PatientRequestConverter implements HttpRequestConverter<Patient> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Patient fromRequest(HttpServletRequest req) {
        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        Date dateOfBirth = dateUtils.parse(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String photo = (String) session.getAttribute("filePath");
        PatientStatus patientStatus = PatientStatus.valueOf(req.getParameter("patientStatus"));
        int userId = (int) session.getAttribute("userId");

        return new Patient(name, surname, phone, dateOfBirth, address, photo, patientStatus, userId);
    }
}
