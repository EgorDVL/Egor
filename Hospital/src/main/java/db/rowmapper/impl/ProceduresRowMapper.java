package db.rowmapper.impl;

import bean.Procedures;
import bean.enums.ProcedureStatus;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 06.01.2017.
 */
public class ProceduresRowMapper implements RowMapper<Procedures> {
    @Override
    public Procedures extract(ResultSet set) throws SQLException {
        Procedures procedures = new Procedures();
        procedures.setProceduresId(set.getInt(1));
        procedures.setNameProcedure(set.getString(2));
        procedures.setUseProcedure(set.getString(3));
        procedures.setDateStartProcedure(set.getDate(4));
        procedures.setDateEndProcedure(set.getDate(5));
        procedures.setProcedureStatus(ProcedureStatus.getValue(set.getString(6)));
        return procedures;
    }
}
