package db.dao.impl;

import bean.AttendingDoctor;
import db.dao.AttendingDoctorDAO;
import db.rowmapper.RowMapper;
import db.rowmapper.impl.AttendingDoctorRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class AttendingDoctorDAOimpl implements AttendingDoctorDAO {

    private static final String CREATE_ATTENDING_DOCTOR = "insert into attendingDoctor values(default, ?, ?)";
    private static final String GET_ATTENDING_DOCTOR_BY_ID = "select * from attendingDoctor where attendingDoctorId = ?";
    private static final String GET_ALL_ATTENDING_DOCTOR = "select * from attendingDoctor";
    private static final String GET_ALL_DOCTORS_ID_BY_PATIENT_ID = "select doctorId from attendingDoctor where patientId = ?";
    private static final String UPDATE_ATTENDING_DOCTOR = "update attendingDoctor set doctorId = ?, patientId = ? where attendingDoctorId = ?";
    private static final String DELETE_ATTENDING_DOCTOR_BY_DOCTOR_ID = "delete from attendingDoctor where doctorId = ?";
    private static final String DELETE_ATTENDING_DOCTOR_BY_PATIENT_ID = "delete from attendingDoctor where patientId = ?";

    private static final String GET_ALL_PATIENTS_ID_BY_DOCTOR_ID = "select patientId from attendingDoctor where doctorId = ?";

    private JdbcTemplate<AttendingDoctor> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createAttendingDoctor(AttendingDoctor attendingDoctor) {
        return jdbcTemplate.create(CREATE_ATTENDING_DOCTOR, attendingDoctor.getDoctorId(), attendingDoctor.getPatientId());
    }

    @Override
    public AttendingDoctor getAttendingDoctorById(int attendingDoctorId) {
        return jdbcTemplate.get(GET_ATTENDING_DOCTOR_BY_ID, new AttendingDoctorRowMapper(), attendingDoctorId);
    }

    @Override
    public List<AttendingDoctor> getAllAttendingDoctors() {
        return jdbcTemplate.getAll(GET_ALL_ATTENDING_DOCTOR, new AttendingDoctorRowMapper());
    }


    @Override
    public List<Integer> getAllDoctorsIdByPatientId(int patientId) {
        return jdbcTemplate.<Integer>getAllParametrized(GET_ALL_DOCTORS_ID_BY_PATIENT_ID, new RowMapper<Integer>() {
            @Override
            public Integer extract(ResultSet set) throws SQLException {
                return set.getInt(1);
            }
        }, patientId);
    }

    @Override
    public boolean updateAttendingDoctor(AttendingDoctor attendingDoctor) {
        return jdbcTemplate.update(UPDATE_ATTENDING_DOCTOR, attendingDoctor.getDoctorId(), attendingDoctor.getPatientId(), attendingDoctor.getAttendingDoctorId());
    }

    @Override
    public boolean deleteAttendingDoctorByDoctorId(int doctorId) {
        return jdbcTemplate.delete(DELETE_ATTENDING_DOCTOR_BY_DOCTOR_ID, doctorId);
    }

    @Override
    public boolean deleteAttendingDoctorByPatientId(int patientId) {
        return jdbcTemplate.delete(DELETE_ATTENDING_DOCTOR_BY_PATIENT_ID, patientId);
    }

    @Override
    public List<Integer> getAllPatientIdByDoctorId(int doctorId) {
        return jdbcTemplate.<Integer>getAllParametrized(GET_ALL_PATIENTS_ID_BY_DOCTOR_ID, new RowMapper<Integer>() {
            @Override
            public Integer extract(ResultSet set) throws SQLException {
                return set.getInt(1);
            }
        }, doctorId);
    }
}
