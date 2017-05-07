package db.rowmapper.impl;

import bean.AttendingDoctor;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class AttendingDoctorRowMapper implements RowMapper<AttendingDoctor> {
    @Override
    public AttendingDoctor extract(ResultSet set) throws SQLException {
        AttendingDoctor attendingDoctor = new AttendingDoctor();
        attendingDoctor.setAttendingDoctorId(set.getInt(1));
        attendingDoctor.setDoctorId(set.getInt(2));
        attendingDoctor.setPatientId(set.getInt(3));
        return attendingDoctor;
    }
}
