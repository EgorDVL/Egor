package service.impl;

import bean.*;
import bean.enums.OperationStatus;
import db.dao.OperationsDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import service.*;

import java.util.Date;

/**
 * Created by Egor on 12.01.2017.
 */
public class OperationsServiceImpl implements OperationService {
    private static final Logger LOG = Logger.getLogger(OperationsServiceImpl.class);
    private OperationsDAO operationsDAO;
    private JournalService journalService;
    private AppointmentService appointmentService;
    private HealingService healingService;
    private HospitalCardService hospitalCardService;

    public OperationsServiceImpl(OperationsDAO operationsDAO) {
        this.operationsDAO = operationsDAO;
    }

    public OperationsServiceImpl(OperationsDAO operationsDAO, JournalService journalService, AppointmentService appointmentService,
                                 HealingService healingService, HospitalCardService hospitalCardService) {
        this(operationsDAO);
        this.journalService = journalService;
        this.appointmentService = appointmentService;
        this.healingService = healingService;
        this.hospitalCardService = hospitalCardService;
    }

    public boolean updateOperation(Operation operation) {
        try {
            return operationsDAO.updateOperations(operation);
        } catch (PersistException e) {
            LOG.error("Can't update operation", e);
            throw new ServiceException("Can't update Operation");
        }
    }

    public int createOperation(Operation operation) {
        try {
            return operationsDAO.createOperations(operation);
        } catch (PersistException e) {
            LOG.error("Can't create operation", e);
            throw new ServiceException("Can't create Operation");
        }
    }


    public Operation getOperationById(int operationId) {
        try {
            return operationsDAO.getOperationsById(operationId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get operation by Id", e);
            throw new ServiceException("Can' get Operation by Id");
        }
    }

    @Override
    public boolean executeOperation(int operationId) {
        Operation operation = operationsDAO.getOperationsById(operationId);
        if (DateUtils.isSameDay(new Date(), operation.getDateOperation())) {
            try {
                operationsDAO.updateOperationsStatus(OperationStatus.DONE, operationId);
                if (journalService != null &&
                        appointmentService != null &&
                        healingService != null &&
                        hospitalCardService != null) {

                    Appointment appointment = appointmentService.getAppointmentByOperationIdId(operationId);
                    Healing healing = healingService.getHealingByAppointmentId(appointment.getAppointmentId());
                    HospitalCard hospitalCard = hospitalCardService.getHospitalCardById(healing.getHospitalCardId());

                    journalService.createJournal(new Journal(new Date(), hospitalCard.getPatientId(), "Execute operation"));
                }
            } catch (PersistException e) {
                LOG.error("Can't execute operation", e);
                throw new ServiceException("Can't execute operation");
            }
        } else {
            LOG.error("Can't execute operation before date operation");
            return false;
        }
        return true;
    }
}