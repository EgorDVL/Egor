package service.impl;

import bean.Appointment;
import db.dao.AppointmentDAO;
import db.dao.impl.AppointmentDAOimpl;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.AppointmentService;

/**
 * Created by Egor on 12.01.2017.
 */
public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger LOG = Logger.getLogger(AppointmentServiceImpl.class);
    private AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }


    public int createAppointment(Appointment appointment) {
        try {
            return appointmentDAO.createAppointment(appointment);
        } catch (PersistException e) {
            LOG.error("Can't create appointment", e);
            throw new ServiceException("Can't create appointment");
        }
    }

    public Appointment getAppointmentById(int appointmentId) {
        try {
            return appointmentDAO.getAppointmentById(appointmentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get appointment by Id");
            throw new ServiceException("Can't get appointment by id");
        }
    }

    public Appointment getAppointmentByOperationIdId(int operationId) {
        try {
            return appointmentDAO.getAppointmentByOperationId(operationId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get appointment by operation Id");
            throw new ServiceException("Can't get appointment by operation id");
        }
    }

    public Appointment getAppointmentByMedicamentId(int medicamentId) {
        try {
            return appointmentDAO.getAppointmentByMedicamentId(medicamentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get appointment by medicamentId");
            throw new ServiceException("Can't get appointment by medicamentid");
        }
    }

    public Appointment getAppointmentByProceduresId(int proceduresId) {
        try {
            return appointmentDAO.getAppointmentByProcedures(proceduresId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get appointment by proceduresId", e);
            throw new ServiceException("Can't get appointment by proceduresid");
        }
    }
}