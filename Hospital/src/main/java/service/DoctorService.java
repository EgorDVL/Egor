package service;

import bean.Doctor;

import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 22.01.2017.
 */
public interface DoctorService {


    List<Doctor> getAllDoctorsByDepartmentId(int departmentId);

    int createDoctor(Doctor doctor);

    Doctor getDoctorById(int doctorId);

    Doctor getDoctorByUserId(int userId);

    List<Doctor> getAllDoctors();

    boolean deleteDoctorById(int doctorId);

    boolean updateDoctor(int doctorId, String name, String surname, String phone, String specialty, int experience);

    boolean updateDoctorTransfer(Doctor doctor);

//    Map<Doctor, Integer> getAllDoctorsAndPatientCount();
}
