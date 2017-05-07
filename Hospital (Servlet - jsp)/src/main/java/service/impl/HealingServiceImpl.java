package service.impl;

import bean.Healing;
import db.dao.HealingDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.HealingService;

import java.util.List;

/**
 * Created by Egor on 12.01.2017.
 */
public class HealingServiceImpl implements HealingService {
    private static final Logger LOG = Logger.getLogger(HealingServiceImpl.class);
    private HealingDAO healingDAO;

    public HealingServiceImpl(HealingDAO healingDAO) {
        this.healingDAO = healingDAO;
    }


    public boolean updateHealing(Healing healing) {
        try {
            return healingDAO.updateHealing(healing);
        } catch (PersistException e) {
            LOG.error("Can't update healing", e);
            throw new ServiceException("Can't update healing");
        }
    }

    public int createHealing(Healing healing) {
        try {
            return healingDAO.createHealing(healing);
        } catch (PersistException e) {
            LOG.error("Can't create healing", e);
            throw new ServiceException("Can't create healing");
        }
    }

    public Healing getHealingById(int healingId) {
        try {
            return healingDAO.getHealingById(healingId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get healing by Id", e);
            throw new ServiceException("Can't get healing by id");
        }
    }

    @Override
    public Healing getHealingByAppointmentId(int appointmentId) {
        try {
            return healingDAO.getHealingByAppointmentId(appointmentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get healing by appointmentId", e);
            throw new ServiceException("Can't get healing by appointmentId", e);
        }
    }

    public List<Healing> getAllHealingByHospitalCard(int hospitalCard) {
        try {
            return healingDAO.getAllHealingsByHospitalCard(hospitalCard);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get healings by Hospital card", e);
            throw new ServiceException("Can't get all healings by hospital card");
        }
    }

    @Override
    public boolean deleteHealingById(int healingId) {
        try {
            return healingDAO.deletehealingById(healingId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete healing by id", e);
            throw new ServiceException("Can't delete healing by id", e);
        }
    }

    @Override
    public Healing getLastPatientHealing(int hospitalCardId) {
        try {
            return healingDAO.getlastHealingPatient(hospitalCardId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get last healing patient by hospital card Id", e);
            throw new ServiceException("Can't get last healing patient by hospital card Id", e);
        }
    }
}