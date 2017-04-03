package service.impl;

import bean.Nurse;
import db.dao.NurseDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.NurseService;

import java.util.List;

/**
 * Created by Egor on 08.01.2017.
 */
public class NurseServiceImpl implements NurseService {
    private static final Logger LOG = Logger.getLogger(NurseServiceImpl.class);
    private NurseDAO nurseDAO;

    public NurseServiceImpl(NurseDAO nurseDAO) {
        this.nurseDAO = nurseDAO;
    }

    public Nurse getNurseByUserId(int userId) {
        try {
            return nurseDAO.getNurseByUserId(userId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get nurse by userId", e);
            throw new ServiceException("Can't nurse by User Id");
        }
    }

    public List<Nurse> getAllNurseByDepartmentId(int departmentId) {
        try {
            return nurseDAO.getAllNurseByDepartment(departmentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all nurse by department id", e);
            throw new ServiceException("Can't get all nurse by department id");
        }
    }

    public int createNurse(Nurse nurse) {
        try {
            return nurseDAO.createNurse(nurse);
        } catch (PersistException e) {
            LOG.error("Can't create nurse", e);
            throw new ServiceException("Cannot create new nurse");
        }
    }

    public Nurse getNurseById(int nurseId) {
        try {
            return nurseDAO.getNurseById(nurseId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get nurse", e);
            throw new ServiceException("Can't get Nurse by Id");
        }
    }

    public List<Nurse> getAllNurses() {
        try {
            return nurseDAO.getAllNurses();
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all nurses", e);
            throw new ServiceException("Can't get all Nurse");
        }
    }

    @Override
    public boolean deleteNurseById(int nurseId) {
        try {
            return nurseDAO.deleteNurseById(nurseId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete nurse", e);
            throw new ServiceException("Can't delete Nurse", e);
        }
    }

    @Override
    public boolean updateNurse(int nurseId, String name, String surname, String phone, String specialty, int experience) {
        try {
            return nurseDAO.updateNurse(nurseId, name, surname, phone, specialty, experience);
        } catch (ObtainObjectException e) {
            LOG.error("Can't update nurse", e);
            throw new ServiceException("Can't update nurse", e);
        }
    }

    @Override
    public boolean updateNurseTransfer(Nurse nurse) {
        try {
            return nurseDAO.updateNurseTransfer(nurse);
        } catch (ObtainObjectException e) {
            LOG.error("Can't update nurse transfer", e);
            throw new ServiceException("Can't update nurse transfer", e);
        }
    }
}
