package db.rowmapper.impl;

import bean.Healing;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class HealingRowMapper implements RowMapper<Healing> {
    @Override
    public Healing extract(ResultSet set) throws SQLException {
        Healing healing = new Healing();
        healing.setHealingId(set.getInt(1));
        healing.setSymptoms(set.getString(2));
        healing.setDateHealingStart(set.getDate(3));
        healing.setDateHealingEnd(set.getDate(4));
        healing.setAppointmentId(set.getInt(5));
        healing.setDiagnosisId(set.getInt(6));
        healing.setHospitalCardId(set.getInt(7));
        return healing;
    }
}
