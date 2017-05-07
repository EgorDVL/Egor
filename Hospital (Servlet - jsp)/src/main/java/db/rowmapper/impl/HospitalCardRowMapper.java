package db.rowmapper.impl;

import bean.HospitalCard;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class HospitalCardRowMapper implements RowMapper<HospitalCard> {
    @Override
    public HospitalCard extract(ResultSet set) throws SQLException {
        HospitalCard hospitalCard = new HospitalCard();
        hospitalCard.setHospitalCardId(set.getInt(1));
        hospitalCard.setPatientId(set.getInt(2));
        return hospitalCard;
    }
}
