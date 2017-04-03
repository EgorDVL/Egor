package service;

import java.util.List;

/**
 * Created by Egor on 22.01.2017.
 */
public interface AttendingDoctorService {

    List<Integer> getAllDoctorsIdByPatientId(int patientId);

    List<Integer> getAllPatientIdByDoctorId(int doctorId);

    int createAttendingDoctor(int doctorId, int patientId);

    boolean deleteAttendingDoctorByDoctorId(int doctorId);

    boolean deleteAttendingDoctorByPatientId(int patientId);
}
