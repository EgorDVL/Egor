package db.dao.impl;

import bean.HospitalCard;
import db.dao.HospitalCardDAO;
import db.rowmapper.impl.HospitalCardRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class HospitalCardDAOimpl implements HospitalCardDAO {
    private static final String CREATE_HOSPITAL_CARD = "insert into hospitalCard values(default, ?)";
    private static final String GET_HOSPITAL_CARD_BY_ID = "select * from hospitalCard where hospitalCardId = ?";
    private static final String GET_HOSPITAL_CARD_BY_PATIENT_ID = "select * from hospitalCard where patientId = ?";
    private static final String GET_ALL_HOSPITAL_CARD = "select * from hospitalCard";
    private static final String UPDATE_HOSPITAL_CARD = "update hospitalCard set patientId = ? where hospitalCardId = ?";
    private static final String DELETE_HOSPITAL_CARD_BY_ID = "delete from hospitalCard where hospitalCardId = ?";


    private JdbcTemplate<HospitalCard> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createHospitalCard(HospitalCard hospitalCard) {
        return jdbcTemplate.create(CREATE_HOSPITAL_CARD, hospitalCard.getPatientId());
    }

    @Override
    public HospitalCard getHospitalCardById(int hospitalCardId) {
        return jdbcTemplate.get(GET_HOSPITAL_CARD_BY_ID, new HospitalCardRowMapper(), hospitalCardId);
    }

    @Override
    public HospitalCard getHospitalCardByPatientId(int patientId) {
        return jdbcTemplate.get(GET_HOSPITAL_CARD_BY_PATIENT_ID, new HospitalCardRowMapper(), patientId);
    }

    @Override
    public List<HospitalCard> getAllHospitalCards() {
        return jdbcTemplate.getAll(GET_ALL_HOSPITAL_CARD, new HospitalCardRowMapper());
    }

    @Override
    public boolean updateHospitalCard(HospitalCard hospitalCard) {
        return jdbcTemplate.update(UPDATE_HOSPITAL_CARD, hospitalCard.getPatientId(), hospitalCard.getHospitalCardId());
    }

    @Override
    public boolean deleteHospitalCardById(int hospitalCardId) {
        return jdbcTemplate.delete(DELETE_HOSPITAL_CARD_BY_ID, hospitalCardId);
    }
}
