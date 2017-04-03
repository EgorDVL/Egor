package db.rowmapper.impl;

import bean.Diagnosis;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class DiagnosisRowMapper implements RowMapper<Diagnosis> {
    @Override
    public Diagnosis extract(ResultSet set) throws SQLException {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisId(set.getInt(1));
        diagnosis.setNameDiagnos(set.getString(2));
        return diagnosis;
    }
}
