package service.impl;

import bean.Patient;
import bean.enums.PatientStatus;
import db.dao.PatientDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.PatientService;

import java.util.List;

/**
 * Created by Egor on 08.01.2017.
 */
public class PatientServiceImpl implements PatientService {

    private static final Logger LOG = Logger.getLogger(PatientServiceImpl.class);

    private PatientDAO patientDAO;

    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }


    @Override
    public int createPatient(Patient patient) {
        try {
            return patientDAO.createPatient(patient);
        } catch (PersistException e) {
            LOG.error("Can't create patient", e);
            throw new ServiceException("Can't create Patient", e);
        }
    }

    @Override
    public Patient getPatientById(int patientId) {
        try {
            return patientDAO.getPatientById(patientId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get patient by Id", e);
            throw new ServiceException("Can't get Patient by id", e);
        }
    }

    @Override
    public Patient getPatientByUserId(int userId) {
        try {
            return patientDAO.getPatientByUserId(userId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get patient by user Id", e);
            throw new ServiceException("Can't get Patient by user id", e);
        }
    }

    @Override
    public List<Patient> getAllPatientsByStatus(PatientStatus patientStatus) {
        try {
            return patientDAO.getAllPatientsByStatus(patientStatus);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all patients by status", e);
            throw new ServiceException("Can't get all patients by status", e);
        }
    }

    @Override
    public List<Patient> sortPatientByParam(String sortParam) {
        try {
            return patientDAO.getSortedPatientByParam(sortParam);
        } catch (ObtainObjectException e) {
            LOG.error("Can't sorted patients", e);
            throw new ServiceException("Can't sort Patient by param");
        }
    }

    @Override
    public List<Patient> findPatientByParam(String surname, String phone, String dateOfBirth) {
        try {
            return patientDAO.getAllPatientSearch(surname, phone, dateOfBirth);
        } catch (ObtainObjectException e) {
            LOG.error("Can't find patient by param", e);
            throw new ServiceException("Can't find Patient by param", e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        try {
            return patientDAO.getAllPatients();
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all patients", e);
            throw new ServiceException("Can't get all Patients");
        }
    }

    @Override
    public boolean updatePatientStatus(int patientId, PatientStatus patientStatus) {
        try {
            return patientDAO.updatePatientStatus(patientStatus, patientId);
        } catch (PersistException e) {
            LOG.error("Can't update patient status", e);
            throw new ServiceException("Can't update Patient's status", e);
        }
    }

    @Override
    public boolean deletePatientById(int patientId) {
        try {
            return patientDAO.deletePatientById(patientId);
        } catch (PersistException e) {
            LOG.error("Can't delete patient by id", e);
            throw new ServiceException("Can't delete patient by id", e);
        }
    }

    @Override
    public boolean updatePatient(int patientId, String name, String surname, String phone, String address) {
        try {
            return patientDAO.updatePatient(patientId, name, surname, phone, address);
        } catch (PersistException e) {
            LOG.error("Can't update patient", e);
            throw new ServiceException("Can't update Patient", e);
        }
    }
}
