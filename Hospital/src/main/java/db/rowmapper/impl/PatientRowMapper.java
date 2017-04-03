package db.rowmapper.impl;

import bean.Patient;
import bean.enums.PatientStatus;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class PatientRowMapper implements RowMapper<Patient> {
    @Override
    public Patient extract(ResultSet set) throws SQLException {
        Patient patient = new Patient();
        patient.setPatientId(set.getInt(1));
        patient.setName(set.getString(2));
        patient.setSurname(set.getString(3));
        patient.setPhone(set.getString(4));
        patient.setDateOfBirth(set.getDate(5));
        patient.setAddress(set.getString(6));
        patient.setPhoto(set.getString(7));
        patient.setPatientStatus(PatientStatus.getValue(set.getString(8)));
        patient.setUserId(set.getInt(9));
        return patient;
    }
}
