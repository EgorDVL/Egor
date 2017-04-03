package db.dao.impl;

import bean.Healing;
import db.dao.HealingDAO;
import db.rowmapper.impl.HealingRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class HealingDAOimpl implements HealingDAO {

    private static final String CREATE_HEALING = "insert into healing values(default, ?, ?, ?, ?, ?, ?)";
    private static final String GET_HEALING_BY_ID = "select * from healing where healingId = ?";
    private static final String GET_HEALING_BY_HOSPITAL_CARD = "select * from healing where hospitalCardId = ?";
    private static final String GET_HEALING_BY_APPOINTMENT_ID = "select * from healing where appointmentId = ?";
    private static final String GET_ALL_HEALING = "select * from healing";
    private static final String GET_ALL_HEALING_BY_HOSPITAL_CARD = "select * from healing where hospitalCardId = ?";
    private static final String UPDATE_HEALING = "update healing set symptoms = ?, date_healing_start = ?, date_healing_end = ?, " +
            "appointmentId = ?, diagnosisId = ?, hospitalCardId = ? where healingId = ?";
    private static final String DELETE_HEALING_BY_ID = "delete from healing where healingId = ?";

    private static final String GET_LAST_HEALING_BY_HOSPITAL_CARD_ID = "SELECT * FROM healing where hospitalCardId = ? ORDER BY healingId DESC LIMIT 1";

    private JdbcTemplate<Healing> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createHealing(Healing healing) {
        return jdbcTemplate.create(CREATE_HEALING,
                healing.getSymptoms(),
                new Date(healing.getDateHealingStart().getTime()),
                new Date(healing.getDateHealingEnd().getTime()),
                healing.getAppointmentId(), healing.getDiagnosisId(), healing.getHospitalCardId());
    }

    @Override
    public Healing getHealingById(int healingId) {
        return jdbcTemplate.get(GET_HEALING_BY_ID, new HealingRowMapper(), healingId);
    }

    @Override
    public Healing getHealingByHospitalCard(int hospitalCard) {
        return jdbcTemplate.get(GET_HEALING_BY_HOSPITAL_CARD, new HealingRowMapper(), hospitalCard);
    }

    @Override
    public Healing getHealingByAppointmentId(int appointmentId) {
        return jdbcTemplate.get(GET_HEALING_BY_APPOINTMENT_ID, new HealingRowMapper(), appointmentId);
    }

    @Override
    public List<Healing> getAllHealings() {
        return jdbcTemplate.getAll(GET_ALL_HEALING, new HealingRowMapper());
    }


    @Override
    public boolean updateHealing(Healing healing) {
        return jdbcTemplate.update(UPDATE_HEALING,
                healing.getSymptoms(),
                new Date(healing.getDateHealingStart().getTime()),
                new Date(healing.getDateHealingEnd().getTime()),
                healing.getAppointmentId(), healing.getDiagnosisId(), healing.getHospitalCardId(), healing.getHealingId());
    }

    @Override
    public boolean deletehealingById(int healingId) {
        return jdbcTemplate.delete(DELETE_HEALING_BY_ID, healingId);
    }

    @Override
    public Healing getlastHealingPatient(int hospitalCardId) {
        return jdbcTemplate.get(GET_LAST_HEALING_BY_HOSPITAL_CARD_ID, new HealingRowMapper(), hospitalCardId);
    }

    @Override
    public List<Healing> getAllHealingsByHospitalCard(int hospitalCard) {
        return jdbcTemplate.getAll(GET_ALL_HEALING_BY_HOSPITAL_CARD, new HealingRowMapper(), hospitalCard);
    }
}