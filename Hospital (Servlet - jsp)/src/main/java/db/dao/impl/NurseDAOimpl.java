package db.dao.impl;

import bean.Nurse;
import db.dao.NurseDAO;
import db.rowmapper.impl.NurseRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class NurseDAOimpl implements NurseDAO {
    private static final String CREATE_NURSE = "insert into nurse values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_NURSE_BY_ID = "select * from nurse where nurseId = ?";
    private static final String GET_NURSE_BY_USER_ID = "select * from nurse where userId = ?";
    private static final String GET_ALL_NURSE = "select * from nurse";
    private static final String GET_ALL_NURSE_BY_DEPARTMENT_ID = "select * from nurse where departmentId = ?";
    private static final String UPDATE_NURSE = "update nurse set name = ?, surname = ?, " +
            "phone = ?, specialty = ?, experience = ? where nurseId = ?";
    private static final String UPDATE_NURSE_TRANSFER = "update nurse set name = ?, surname = ?, " +
            "phone = ?, specialty = ?,dateOfBirth = ?, experience = ?, photo = ?, departmentId = ? , userId = ? where nurseId = ?";
    private static final String DELETE_NURSE_BY_ID = "delete from nurse where nurseId = ?";

    private JdbcTemplate<Nurse> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createNurse(Nurse nurse) {
        return jdbcTemplate.create(CREATE_NURSE,
                nurse.getName(), nurse.getSurname(),
                nurse.getPhone(), nurse.getSpecialty(),
                new Date(nurse.getDateOfBirth().getTime()),
                nurse.getExperience(),
                nurse.getPhoto(),
                nurse.getDepartment().getValue(),
                nurse.getUserId());
    }

    @Override
    public Nurse getNurseById(int nurseId) {
        return jdbcTemplate.get(GET_NURSE_BY_ID, new NurseRowMapper(), nurseId);
    }

    @Override
    public Nurse getNurseByUserId(int userId) {
        return jdbcTemplate.get(GET_NURSE_BY_USER_ID, new NurseRowMapper(), userId);
    }

    @Override
    public List<Nurse> getAllNurses() {
        return jdbcTemplate.getAll(GET_ALL_NURSE, new NurseRowMapper());
    }

    @Override
    public List<Nurse> getAllNurseByDepartment(int departmentId) {
        return jdbcTemplate.getAll(GET_ALL_NURSE_BY_DEPARTMENT_ID, new NurseRowMapper(), departmentId);
    }

    @Override
    public boolean updateNurse(int nurseId, String name, String surname, String phone, String specialty, int experience) {
        return jdbcTemplate.update(UPDATE_NURSE, name, surname, phone, specialty, experience, nurseId);
    }

    @Override
    public boolean updateNurseTransfer(Nurse nurse) {
        return jdbcTemplate.update(UPDATE_NURSE_TRANSFER,
                nurse.getName(),
                nurse.getSurname(),
                nurse.getPhone(),
                nurse.getSpecialty(),
                new Date(nurse.getDateOfBirth().getTime()),
                nurse.getExperience(),
                nurse.getPhoto(),
                nurse.getDepartment().getValue(),
                nurse.getUserId(),
                nurse.getNurseId());
    }


    @Override
    public boolean deleteNurseById(int nurseId) {
        return jdbcTemplate.delete(DELETE_NURSE_BY_ID, nurseId);
    }
}