package service.impl;

import bean.*;
import bean.enums.ProcedureStatus;
import db.dao.ProceduresDAO;
import db.exception.ObtainObjectException;
import db.exception.PersistException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.*;
import util.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Egor on 12.01.2017.
 */
public class ProceduresServiceImpl implements ProceduresService {
    private static final Logger LOG = Logger.getLogger(ProceduresServiceImpl.class);

    private ProceduresDAO proceduresDAO;

    private JournalService journalService;
    private AppointmentService appointmentService;
    private HealingService healingService;
    private HospitalCardService hospitalCardService;

    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    public ProceduresServiceImpl(ProceduresDAO proceduresDAO) {
        this.proceduresDAO = proceduresDAO;
    }

    public ProceduresServiceImpl(ProceduresDAO proceduresDAO, JournalService journalService, AppointmentService appointmentService,
                                 HealingService healingService, HospitalCardService hospitalCardService) {
        this(proceduresDAO);
        this.journalService = journalService;
        this.appointmentService = appointmentService;
        this.healingService = healingService;
        this.hospitalCardService = hospitalCardService;
    }

    public void cancelExecuteProcedures() {
        Date currentDate = new Date();
        try {
            List<Procedures> proceduresList = proceduresDAO.getAllProceduresByStatus(ProcedureStatus.DONE);

            for (Procedures procedure : proceduresList) {
                if (dateUtils.parse(procedure.getDateStartProcedure().toString()).before(currentDate) &&
                        dateUtils.parse(procedure.getDateEndProcedure().toString()).after(currentDate)) {

                    proceduresDAO.updateProcedureStatus(ProcedureStatus.NOT_DONE, procedure.getProceduresId());
                }
            }
        } catch (PersistException e) {
            LOG.error("Can't cancel execute procedure", e);
            throw new ServiceException("Can't cancel execute procedure");
        }
    }

    @Override
    public boolean executeProcedures(int proceduresId) {
        Procedures procedures = proceduresDAO.getProceduresById(proceduresId);
        if (dateUtils.parse(procedures.getDateStartProcedure().toString()).before(new Date()) &&
                dateUtils.parse(procedures.getDateEndProcedure().toString()).after(new Date())) {
            try {

                proceduresDAO.updateProcedureStatus(ProcedureStatus.DONE, proceduresId);
                if (journalService != null &&
                        appointmentService != null &&
                        healingService != null &&
                        hospitalCardService != null) {

                    Appointment appointment = appointmentService.getAppointmentByProceduresId(proceduresId);
                    Healing healing = healingService.getHealingByAppointmentId(appointment.getAppointmentId());
                    HospitalCard hospitalCard = hospitalCardService.getHospitalCardById(healing.getHospitalCardId());

                    journalService.createJournal(new Journal(new Date(), hospitalCard.getPatientId(), "Execute procedure"));
                }
                return true;
            } catch (PersistException e) {
                LOG.error("Can't execute procedures", e);
                throw new ServiceException("Can't execute procedures");
            }
        }
        return false;
    }

    public boolean updateProceduresStatus(int procedureId, ProcedureStatus procedureStatus) {
        try {
            return proceduresDAO.updateProcedureStatus(procedureStatus, procedureId);
        } catch (PersistException e) {
            LOG.error("Can't update procedure status", e);
            throw new ServiceException("Can't update procedure status");
        }
    }

    public boolean updateProcedures(Procedures procedures) {
        try {
            return proceduresDAO.updateProcedures(procedures);
        } catch (PersistException e) {
            LOG.error("Can't update procedures", e);
            throw new ServiceException("Can't update procedures");
        }
    }

    public int createProcedures(Procedures procedures) {
        try {
            return proceduresDAO.createProcedures(procedures);
        } catch (PersistException e) {
            LOG.error("Can't create procedures", e);
            throw new ServiceException("Can't create Procedures");
        }
    }

    public Procedures getProceduresById(int proceduresId) {
        try {
            return proceduresDAO.getProceduresById(proceduresId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get procedures by Id", e);
            throw new ServiceException("Can't get procedures by Id");
        }
    }
}
