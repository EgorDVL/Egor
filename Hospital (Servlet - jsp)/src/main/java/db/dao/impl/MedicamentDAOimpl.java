package db.dao.impl;

import bean.Medicament;
import bean.enums.MedicamentStatus;
import db.dao.MedicamentDAO;
import db.rowmapper.impl.MedicamentRowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Egor on 06.01.2017.
 */
public class MedicamentDAOimpl implements MedicamentDAO {
    private static final String CREATE_MEDICAMENT = "insert into medicament values(default, ?, ?, ?, ?, ?, ?)";
    private static final String GET_MEDICAMENT_BY_ID = "select * from medicament where medicamentId = ?";
    private static final String GET_ALL_MEDICAMENT = "select * from medicament";
    private static final String GET_ALL_MEDICAMENT_BY_STATUS = "select * from medicament where status = ?";
    private static final String UPDATE_MEDICAMENT = "update medicament set name = ?, type = ?, `use` = ?, date_start = ?," +
            " date_end = ?, status = ? where medicamentId = ?";
    private static final String UPDATE_MEDICAMENT_STATUS = "update medicament set status = ? where medicamentId = ?";


    private JdbcTemplate<Medicament> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createMedicament(Medicament medicament) {
        return jdbcTemplate.create(CREATE_MEDICAMENT,
                medicament.getNameMedicament(),
                medicament.getMedicamentEnum().toString(),
                medicament.getUseMedicament(),
                new Date(medicament.getDateStartMedicament().getTime()),
                new Date(medicament.getDateEndMedicament().getTime()),
                medicament.getMedicamentStatus().toString());
    }

    @Override
    public Medicament getMedicamentById(int medicamentId) {
        return jdbcTemplate.get(GET_MEDICAMENT_BY_ID, new MedicamentRowMapper(), medicamentId);
    }

    @Override
    public List<Medicament> getAllMedicaments() {
        return jdbcTemplate.getAll(GET_ALL_MEDICAMENT, new MedicamentRowMapper());
    }

    @Override
    public List<Medicament> getAllMedicamentByStatus(MedicamentStatus medicamentStatus) {
        return jdbcTemplate.getAll(GET_ALL_MEDICAMENT_BY_STATUS, new MedicamentRowMapper(), medicamentStatus.toString());
    }

    @Override
    public boolean updateMedicament(Medicament medicament) {
        return jdbcTemplate.update(UPDATE_MEDICAMENT,
                medicament.getNameMedicament(),
                medicament.getMedicamentEnum().toString(),
                medicament.getUseMedicament(),
                new Date(medicament.getDateStartMedicament().getTime()),
                new Date(medicament.getDateEndMedicament().getTime()),
                medicament.getMedicamentStatus().toString(),
                medicament.getMedicamentId());
    }

    @Override
    public boolean updateMedicamentStatus(MedicamentStatus medicamentStatus, int medicamentId) {
        return jdbcTemplate.update(UPDATE_MEDICAMENT_STATUS, medicamentStatus.toString(), medicamentId);
    }
}