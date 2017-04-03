package db.rowmapper.impl;

import bean.Journal;
import db.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 25.01.2017.
 */
public class JournalRowMapper implements RowMapper<Journal> {
    @Override
    public Journal extract(ResultSet set) throws SQLException {

        Journal journal = new Journal();
        journal.setPatientId(set.getInt(1));
        journal.setDate(set.getDate(2));
        journal.setPatientId(set.getInt(3));
        journal.setMessage(set.getString(4));
        return journal;
    }
}
