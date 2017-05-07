package db.dao.impl;

import bean.Journal;
import db.dao.JournalDAO;
import db.rowmapper.impl.JournalRowMapper;

import java.sql.Date;
import java.util.List;

/**
 * Created by Egor on 24.01.2017.
 */
public class JournalDAOimpl implements JournalDAO {

    private static final String CREATE_JOURNAL = "insert into journal values(default, ?, ?, ?)";
    private static final String GET_JOURNAL_PATIENT = "select * from journal where patientId = ?";
    private static final String DELETE_JOURNAL_BY_PATIENT_ID = "delete from journal where patientId = ?";


    private JdbcTemplate<Journal> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public int createJournal(Journal journal) {
        return jdbcTemplate.create(CREATE_JOURNAL, new Date(journal.getDate().getTime()), journal.getPatientId(), journal.getMessage());
    }

    @Override
    public List<Journal> getJournalPatient(int patientId) {
        return jdbcTemplate.getAll(GET_JOURNAL_PATIENT, new JournalRowMapper(), patientId);
    }

    @Override
    public boolean deleteJournalByPatientId(int patientId) {
        return jdbcTemplate.delete(DELETE_JOURNAL_BY_PATIENT_ID, patientId);
    }
}
