package db.dao.impl;

import bean.Diagnosis;
import db.dao.DiagnosisDAO;
import db.rowmapper.impl.DiagnosisRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class DiagnosisDAOimpl implements DiagnosisDAO {
    private static final String CREATE_DIAGNOSIS = "insert into diagnosis values(default, ?)";
    private static final String GET_DIAGNOSIS_BY_ID = "select * from diagnosis where diagnosisId = ?";
    private static final String GET_ALL_DIAGNOSIS = "select * from diagnosis";
    private static final String UPDATE_DIAGNOSIS = "update diagnosis set name = ? where diagnosisId = ?";

    private JdbcTemplate<Diagnosis> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createDiagnosis(Diagnosis diagnosis) {
        return jdbcTemplate.create(CREATE_DIAGNOSIS, diagnosis.getNameDiagnos());
    }

    @Override
    public Diagnosis getDiagnosisById(int diagnosisId) {
        return jdbcTemplate.get(GET_DIAGNOSIS_BY_ID, new DiagnosisRowMapper(), diagnosisId);
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        return jdbcTemplate.getAll(GET_ALL_DIAGNOSIS, new DiagnosisRowMapper());
    }

    @Override
    public boolean updateDiagnosis(Diagnosis diagnosis) {
        return jdbcTemplate.update(UPDATE_DIAGNOSIS, diagnosis.getNameDiagnos(), diagnosis.getDiagnosisId());
    }
}
