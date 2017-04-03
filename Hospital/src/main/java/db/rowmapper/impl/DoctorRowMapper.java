package db.rowmapper.impl;

import bean.Doctor;
import bean.enums.DepartmentEnum;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class DoctorRowMapper implements RowMapper<Doctor> {
    @Override
    public Doctor extract(ResultSet set) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(set.getInt(1));
        doctor.setName(set.getString(2));
        doctor.setSurname(set.getString(3));
        doctor.setPhone(set.getString(4));
        doctor.setSpecialty(set.getString(5));
        doctor.setDateOfBirth(set.getDate(6));
        doctor.setExperience(set.getInt(7));
        doctor.setPhoto(set.getString(8));
        doctor.setDepartment(DepartmentEnum.fromValue(set.getInt(9)));
        doctor.setUserId(set.getInt(10));
        return doctor;
    }
}
