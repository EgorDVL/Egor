package service;

import bean.Patient;
import bean.enums.PatientStatus;

import java.util.List;

/**
 * Created by Egor on 22.01.2017.
 */
public interface PatientService {

    int createPatient(Patient patient);

    Patient getPatientById(int patientId);

    Patient getPatientByUserId(int userId);

    List<Patient> getAllPatientsByStatus(PatientStatus patientStatus);

    List<Patient> sortPatientByParam(String sortParam);

    List<Patient> findPatientByParam(String surname, String phone, String dateOfBirth);

    List<Patient> getAllPatients();

    boolean updatePatientStatus(int patientId, PatientStatus patientStatus);

    boolean deletePatientById(int patientId);

    boolean updatePatient(int patientId, String name, String surname, String phone, String address);

}
