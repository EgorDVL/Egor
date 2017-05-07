package service.impl;

import bean.Journal;
import db.dao.JournalDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.JournalService;

import java.util.List;

/**
 * Created by Egor on 24.01.2017.
 */
public class JournalServiceImpl implements JournalService {

    private static final Logger LOG = Logger.getLogger(AttendingDoctorServiceImpl.class);
    private JournalDAO journalDAO;

    public JournalServiceImpl(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    @Override
    public int createJournal(Journal journal) {
        try {
            return journalDAO.createJournal(journal);
        } catch (PersistException e) {
            LOG.error("Can't create journal", e);
            throw new ServiceException("Can't create journal");
        }
    }

    @Override
    public List<Journal> getJournalPatient(int patientId) {
        try {
            return journalDAO.getJournalPatient(patientId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get journal's patient", e);
            throw new ServiceException("Can't get journal's patient");
        }
    }

    @Override
    public boolean deleteJournalBtPatientId(int patientId) {
        try {
            return journalDAO.deleteJournalByPatientId(patientId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete journal by patient id", e);
            throw new ServiceException("Can't delete journal by patient id", e);
        }
    }
}
