package db.dao.impl;

import bean.Appointment;
import db.dao.AppointmentDAO;
import db.rowmapper.impl.AppointmentRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class AppointmentDAOimpl implements AppointmentDAO {


    private static final String CREATE_APPOINTMENT = "insert into appointment values(default, ?, ?, ?, ?, ?)";
    private static final String GET_APPOINTMENT_BY_ID = "select * from appointment where appointmentId = ?";
    private static final String GET_APPOINTMENT_BY_OPERATION_ID = "select * from appointment where operationsId = ?";
    private static final String GET_APPOINTMENT_BY_MEDICAMENT_ID = "select * from appointment where medicamentId = ?";
    private static final String GET_APPOINTMENT_BY_PROCEDURES_ID = "select * from appointment where proceduresId = ?";
    private static final String GET_ALL_APPOINTMENT = "select * from appointment";
    private static final String UPDATE_APPOINTMENT = "update appointment set name = ?, date = ?, operationsId = ?, " +
            "medicamentId = ?, proceduresId = ? where appointmentId = ?";

    private JdbcTemplate<Appointment> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createAppointment(Appointment appointment) {
        return jdbcTemplate.create(CREATE_APPOINTMENT, appointment.getNameAppointment(),
                new Date(appointment.getDateAppointment().getTime()), appointment.getOperationId(),
                appointment.getMedicamentId(), appointment.getProceduresId());
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return jdbcTemplate.get(GET_APPOINTMENT_BY_ID, new AppointmentRowMapper(), appointmentId);
    }

    @Override
    public Appointment getAppointmentByOperationId(int operationId) {
        return jdbcTemplate.get(GET_APPOINTMENT_BY_OPERATION_ID, new AppointmentRowMapper(), operationId);
    }

    @Override
    public Appointment getAppointmentByMedicamentId(int medicamentId) {
        return jdbcTemplate.get(GET_APPOINTMENT_BY_MEDICAMENT_ID, new AppointmentRowMapper(), medicamentId);
    }

    @Override
    public Appointment getAppointmentByProcedures(int proceduresId) {
        return jdbcTemplate.get(GET_APPOINTMENT_BY_PROCEDURES_ID, new AppointmentRowMapper(), proceduresId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return jdbcTemplate.getAll(GET_ALL_APPOINTMENT, new AppointmentRowMapper());
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        return jdbcTemplate.update(UPDATE_APPOINTMENT, appointment.getNameAppointment(), new Date(appointment.getDateAppointment().getTime()),
                appointment.getOperationId(), appointment.getMedicamentId(), appointment.getProceduresId(), appointment.getAppointmentId());
    }
}
