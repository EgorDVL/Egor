package db.dao.impl;

import bean.Patient;
import bean.enums.PatientStatus;
import db.DBManager;
import db.QueryBuilderSQL;
import db.dao.PatientDAO;
import db.rowmapper.impl.PatientRowMapper;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class PatientDAOimpl implements PatientDAO {
    private static final String CREATE_PATIENT = "insert into patient values(default, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PATIENT_BY_ID = "select * from patient where patientId = ?";
    private static final String GET_PATIENT_BY_USER_ID = "select * from patient where userId = ?";
    private static final String GET_ALL_PATIENT = "select * from patient";
    private static final String GET_ALL_PATIENT_BY_STATUS = "select * from patient where status = ?";
    private static final String UPDATE_PATIENT = "update patient set name = ?, " +
            "surname = ?, phone = ?, address = ? where patientId = ?";
    private static final String UPDATE_PATIENT_STATUS = "update patient set status = ? where patientId = ?";
    private static final String DELETE_PATIENT_BY_ID = "delete from patient where patientId = ?";

    private static final String SORT_PATIENT_BY_PARAM = "select * from patient order by ";


    private JdbcTemplate<Patient> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createPatient(Patient patient) {
        return jdbcTemplate.create(CREATE_PATIENT,
                patient.getName(), patient.getSurname(), patient.getPhone(),
                new Date(patient.getDateOfBirth().getTime()),
                patient.getAddress(),
                patient.getPhoto(),
                patient.getPatientStatus().toString(),
                patient.getUserId());
    }

    @Override
    public Patient getPatientById(int patientId) {
        return jdbcTemplate.get(GET_PATIENT_BY_ID, new PatientRowMapper(), patientId);
    }

    @Override
    public Patient getPatientByUserId(int userId) {
        return jdbcTemplate.get(GET_PATIENT_BY_USER_ID, new PatientRowMapper(), userId);
    }

    @Override
    public List<Patient> getAllPatients() {
        return jdbcTemplate.getAll(GET_ALL_PATIENT, new PatientRowMapper());
    }

    @Override
    public List<Patient> getAllPatientsByStatus(PatientStatus patientStatus) {
        return jdbcTemplate.getAll(GET_ALL_PATIENT_BY_STATUS, new PatientRowMapper(), patientStatus.toString());
    }

    @Override
    public List<Patient> getSortedPatientByParam(String sortParam) {
        QueryBuilderSQL queryBuilderSQL = new QueryBuilderSQL();
        return jdbcTemplate.getAll(queryBuilderSQL.select().all().from("patient").orderBy(sortParam).build(),
                new PatientRowMapper());
    }

    @Override
    public List<Patient> getAllPatientSearch(String surname, String phone, String dateOfBirth) {
        QueryBuilderSQL queryBuilderSQL = new QueryBuilderSQL();
        return jdbcTemplate.getAll(
                queryBuilderSQL.select().all().from("patient").where().in("surname", surname).in("phone", phone).in("dateOfBirth", dateOfBirth).build(),
                new PatientRowMapper());
    }

    @Override
    public boolean updatePatient(int patientId, String name, String surname, String phone, String address) {
        return jdbcTemplate.update(UPDATE_PATIENT, name, surname, phone, address, patientId);
    }

    @Override
    public boolean updatePatientStatus(PatientStatus patientStatus, int patientId) {
        return jdbcTemplate.update(UPDATE_PATIENT_STATUS, patientStatus.toString(), patientId);
    }

    @Override
    public boolean deletePatientById(int patientId) {
        return jdbcTemplate.delete(DELETE_PATIENT_BY_ID, patientId);
    }
}