package service;

import bean.Appointment;

/**
 * Created by Egor on 22.01.2017.
 */
public interface AppointmentService {

    int createAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    Appointment getAppointmentByOperationIdId(int operationId);

    Appointment getAppointmentByMedicamentId(int medicamentId);

    Appointment getAppointmentByProceduresId(int proceduresId);
}
