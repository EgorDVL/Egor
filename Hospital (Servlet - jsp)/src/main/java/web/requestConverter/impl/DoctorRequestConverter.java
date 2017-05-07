package web.requestConverter.impl;

import bean.Doctor;
import bean.enums.DepartmentEnum;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class DoctorRequestConverter implements HttpRequestConverter<Doctor> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Doctor fromRequest(HttpServletRequest req) {
        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String specialty = req.getParameter("specialty");
        Date dateOfBirth = dateUtils.parse(req.getParameter("dateOfBirth"));

        String experienceStr = req.getParameter("experience");
        int experience = 0;
        if (!(experienceStr.isEmpty()) || experienceStr == null) {
            experience = Integer.parseInt(experienceStr);
        }

        String photo = (String) session.getAttribute("filePath");
        DepartmentEnum departmentEnum = DepartmentEnum.getValue(req.getParameter("department"));
        int userId = (int) session.getAttribute("userId");
        return new Doctor(name, surname, phone, specialty, dateOfBirth, experience, photo, departmentEnum, userId);
    }
}
