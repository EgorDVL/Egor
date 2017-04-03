package db.dao;

import bean.Patient;
import bean.enums.PatientStatus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public interface PatientDAO {
    int createPatient(Patient patient);

    Patient getPatientById(int patientId);

    Patient getPatientByUserId(int userId);

    List<Patient> getAllPatients();

    List<Patient> getAllPatientsByStatus(PatientStatus patientStatus);

    List<Patient> getSortedPatientByParam(String sortParam);

    List<Patient> getAllPatientSearch(String surname, String phone, String dateOfBirth);

    boolean updatePatient(int patientId, String name, String surname, String phone, String address);

    boolean updatePatientStatus(PatientStatus patientStatus, int patientId);

    boolean deletePatientById(int patientId);

}
