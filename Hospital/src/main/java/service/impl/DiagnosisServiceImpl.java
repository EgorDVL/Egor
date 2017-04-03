package service.impl;

import bean.Diagnosis;
import db.dao.DiagnosisDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.DiagnosisService;

/**
 * Created by Egor on 12.01.2017.
 */
public class DiagnosisServiceImpl implements DiagnosisService {
    private static final Logger LOG = Logger.getLogger(DiagnosisServiceImpl.class);
    private DiagnosisDAO diagnosisDAO;

    public DiagnosisServiceImpl(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public boolean updateDiagnosis(Diagnosis diagnosis) {
        try {
            return diagnosisDAO.updateDiagnosis(diagnosis);
        } catch (PersistException e) {
            LOG.error("Can't update diagnosis", e);
            throw new ServiceException("Can't update diagnosis");
        }
    }

    public int createDiagnosis(String diagnosisName) {
        Diagnosis diagnosis = new Diagnosis(diagnosisName);
        try {
            return diagnosisDAO.createDiagnosis(diagnosis);
        } catch (PersistException e) {
            LOG.error("Can't create diagnosis", e);
            throw new ServiceException("Can't create diagnosis");
        }
    }

    public Diagnosis getDiagnosisById(int diagnosisId) {
        try {
            return diagnosisDAO.getDiagnosisById(diagnosisId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get diagnosis by Id", e);
            throw new ServiceException("Can't get diagnosis by Id");
        }
    }
}