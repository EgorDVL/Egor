package db.dao;

import bean.Appointment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface AppointmentDAO {
    int createAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    Appointment getAppointmentByOperationId(int operationId);

    Appointment getAppointmentByMedicamentId(int medicamentId);

    Appointment getAppointmentByProcedures(int proceduresId);

    List<Appointment> getAllAppointments();

    boolean updateAppointment(Appointment appointment);
}
