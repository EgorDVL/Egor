package service.impl;

import bean.AttendingDoctor;
import db.dao.AttendingDoctorDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;

import java.util.List;

/**
 * Created by Egor on 13.01.2017.
 */
public class AttendingDoctorServiceImpl implements AttendingDoctorService {

    private static final Logger LOG = Logger.getLogger(AttendingDoctorServiceImpl.class);
    private AttendingDoctorDAO attendingDoctorDAO;

    public AttendingDoctorServiceImpl(AttendingDoctorDAO attendingDoctorDAO) {
        this.attendingDoctorDAO = attendingDoctorDAO;
    }


    public List<Integer> getAllDoctorsIdByPatientId(int patientId) {
        try {
            return attendingDoctorDAO.getAllDoctorsIdByPatientId(patientId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get doctors id by patient Id", e);
            throw new ServiceException("Can't get all Doctors id by Patient Id", e);
        }
    }


    public List<Integer> getAllPatientIdByDoctorId(int doctorId) {
        try {
            return attendingDoctorDAO.getAllPatientIdByDoctorId(doctorId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get patientId by doctorId", e);
            throw new ServiceException("Can't get all Patient id by Doctor Id", e);
        }
    }

    public int createAttendingDoctor(int doctorId, int patientId) {
        AttendingDoctor attendingDoctor = new AttendingDoctor(doctorId, patientId);
        try {
            return attendingDoctorDAO.createAttendingDoctor(attendingDoctor);
        } catch (PersistException e) {
            LOG.error("Can't create attending doctor", e);
            throw new ServiceException("Can't create attending doctor", e);
        }
    }

    public boolean deleteAttendingDoctorByDoctorId(int doctorId) {
        try {
            return attendingDoctorDAO.deleteAttendingDoctorByDoctorId(doctorId);
        } catch (PersistException e) {
            LOG.error("Can't delete attending doctor by doctorId");
            throw new ServiceException("Can't delete attending doctor by doctorId", e);
        }
    }

    @Override
    public boolean deleteAttendingDoctorByPatientId(int patientId) {
        try {
            return attendingDoctorDAO.deleteAttendingDoctorByPatientId(patientId);
        } catch (PersistException e) {
            LOG.error("Can't delete attending doctor by patientId");
            throw new ServiceException("Can't delete attending doctor by patientId", e);
        }
    }
}