package service.impl;

import bean.HospitalCard;
import db.dao.HospitalCardDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.HospitalCardService;

/**
 * Created by Egor on 11.01.2017.
 */
public class HospitalCardServiceImpl implements HospitalCardService {
    private static final Logger LOG = Logger.getLogger(HospitalCardServiceImpl.class);

    private HospitalCardDAO hospitalCardDAO;

    public HospitalCardServiceImpl(HospitalCardDAO hospitalCardDAO) {
        this.hospitalCardDAO = hospitalCardDAO;
    }

    public int createHospitalCard(int patientId) {
        HospitalCard hospitalCard = new HospitalCard(patientId);
        try {
            return hospitalCardDAO.createHospitalCard(hospitalCard);
        } catch (PersistException e) {
            LOG.error("Can't create hospitalCard", e);
            throw new ServiceException("Can't create hospital card");
        }
    }

    public HospitalCard getHospitalCardByPatientId(int patientId) {
        try {
            return hospitalCardDAO.getHospitalCardByPatientId(patientId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get hospitalCard by patient id", e);
            throw new ServiceException("Can't get hospital card by Patient id");
        }
    }

    public HospitalCard getHospitalCardById(int hospitalCardId) {
        try {
            return hospitalCardDAO.getHospitalCardById(hospitalCardId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get hospitalCard by Id", e);
            throw new ServiceException("Can't get hospital card by Id");
        }
    }

    @Override
    public boolean deleteHospitalCardById(int hospitalCardId) {
        try {
            return hospitalCardDAO.deleteHospitalCardById(hospitalCardId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't delete hospitalCard by Id", e);
            throw new ServiceException("Can't delete hospital card by Id", e);
        }
    }
}