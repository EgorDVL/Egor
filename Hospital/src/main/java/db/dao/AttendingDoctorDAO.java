package db.dao;

import bean.AttendingDoctor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface AttendingDoctorDAO {
    int createAttendingDoctor(AttendingDoctor attendingDoctor);

    AttendingDoctor getAttendingDoctorById(int attendingDoctorId);

    List<AttendingDoctor> getAllAttendingDoctors();

    List<Integer> getAllPatientIdByDoctorId(int doctorId);

    List<Integer> getAllDoctorsIdByPatientId(int patientId);

    boolean updateAttendingDoctor(AttendingDoctor attendingDoctor);

    boolean deleteAttendingDoctorByDoctorId(int doctorId);

    boolean deleteAttendingDoctorByPatientId(int patientId);
}
