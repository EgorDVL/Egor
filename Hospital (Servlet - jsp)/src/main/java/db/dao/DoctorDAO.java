package db.dao;

import bean.Doctor;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface DoctorDAO {
    int createDoctor(Doctor doctor);

    Doctor getDoctorById(int doctorId);

    Doctor getDoctorByUserId(int userId);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDoctorsByDepartment(int departmentId);

    boolean updateDoctor(int doctorId, String name, String surname, String phone, String specialty, int experience);

    boolean updateDoctorTransfer(Doctor doctor);

    boolean deleteDoctor(int doctorId);
}
