package db.dao.impl;

import bean.Doctor;
import db.dao.DoctorDAO;
import db.rowmapper.impl.DoctorRowMapper;

import java.sql.Date;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class DoctorDAOimpl implements DoctorDAO {
    private static final String CREATE_DOCTOR = "insert into doctor values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_DOCTOR_BY_ID = "select * from doctor where doctorId = ?";
    private static final String GET_DOCTOR_BY_USER_ID = "select * from doctor where userId = ?";
    private static final String GET_ALL_DOCTOR = "select * from doctor";
    private static final String GET_ALL_DOCTOR_BY_DEPARTMENT_ID = "select * from doctor where departmentId = ?";
    private static final String UPDATE_DOCTOR = "update doctor set name = ?,surname = ?," +
            " phone = ?, specialty = ?, experience = ? where doctorId = ?";

    private static final String UPDATE_DOCTOR_TRANSFER = "update doctor set name = ?,surname = ?," +
            " phone = ?, specialty = ?,dateOfBirth = ?, experience = ?, photo = ?, departmentId = ?, userId = ?  where doctorId = ?";

    private static final String DELETE_DOCTOR_BY_ID = "delete from doctor where doctorId = ?";

    private JdbcTemplate<Doctor> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createDoctor(Doctor doctor) {
        return jdbcTemplate.create(CREATE_DOCTOR,
                doctor.getName(),
                doctor.getSurname(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                new Date(doctor.getDateOfBirth().getTime()),
                doctor.getExperience(),
                doctor.getPhoto(),
                doctor.getDepartment().getValue(),
                doctor.getUserId());
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        return jdbcTemplate.get(GET_DOCTOR_BY_ID, new DoctorRowMapper(), doctorId);
    }

    @Override
    public Doctor getDoctorByUserId(int userId) {
        return jdbcTemplate.get(GET_DOCTOR_BY_USER_ID, new DoctorRowMapper(), userId);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.getAll(GET_ALL_DOCTOR, new DoctorRowMapper());
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartment(int departmentId) {
        return jdbcTemplate.getAll(GET_ALL_DOCTOR_BY_DEPARTMENT_ID, new DoctorRowMapper(), departmentId);
    }

    @Override
    public boolean updateDoctor(int doctorId, String name, String surname, String phone, String specialty, int experience) {
        return jdbcTemplate.update(UPDATE_DOCTOR, name, surname, phone, specialty, experience, doctorId);
    }

    @Override
    public boolean updateDoctorTransfer(Doctor doctor) {
        return jdbcTemplate.update(UPDATE_DOCTOR_TRANSFER,
                doctor.getName(),
                doctor.getSurname(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                new Date(doctor.getDateOfBirth().getTime()),
                doctor.getExperience(),
                doctor.getPhoto(),
                doctor.getDepartment().getValue(),
                doctor.getUserId(),
                doctor.getDoctorId());
    }

    @Override
    public boolean deleteDoctor(int doctorId) {
        return jdbcTemplate.delete(DELETE_DOCTOR_BY_ID, doctorId);
    }
}