package db.rowmapper.impl;

import bean.Appointment;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class AppointmentRowMapper implements RowMapper<Appointment> {

    @Override
    public Appointment extract(ResultSet set) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(set.getInt(1));
        appointment.setNameAppointment(set.getString(2));
        appointment.setDateAppointment(set.getDate(3));
        appointment.setOperationId(set.getInt(4));
        appointment.setMedicamentId(set.getInt(5));
        appointment.setProceduresId(set.getInt(6));
        return appointment;
    }
}
