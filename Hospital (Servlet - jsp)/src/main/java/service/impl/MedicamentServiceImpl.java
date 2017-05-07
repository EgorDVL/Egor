package service.impl;

import bean.*;
import bean.enums.MedicamentStatus;
import db.dao.MedicamentDAO;
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
public class MedicamentServiceImpl implements MedicamentService {
    private static final Logger LOG = Logger.getLogger(MedicamentServiceImpl.class);
    private MedicamentDAO medicamentDAO;
    private JournalService journalService;
    private AppointmentService appointmentService;
    private HealingService healingService;
    private HospitalCardService hospitalCardService;

    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    public MedicamentServiceImpl(MedicamentDAO medicamentDAO) {
        this.medicamentDAO = medicamentDAO;
    }

    public MedicamentServiceImpl(MedicamentDAO medicamentDAO, JournalService journalService, AppointmentService appointmentService,
                                 HealingService healingService, HospitalCardService hospitalCardService) {
        this(medicamentDAO);
        this.journalService = journalService;
        this.appointmentService = appointmentService;
        this.healingService = healingService;
        this.hospitalCardService = hospitalCardService;
    }


    public void cancelExecuteMedicament() {
        Date currentDate = new Date();
        try {
            List<Medicament> medicamentList = medicamentDAO.getAllMedicamentByStatus(MedicamentStatus.DONE);

            for (Medicament medicament : medicamentList) {
                if (dateUtils.parse(medicament.getDateStartMedicament().toString()).before(currentDate)
                        && dateUtils.parse(medicament.getDateEndMedicament().toString()).after(currentDate)) {

                    medicamentDAO.updateMedicamentStatus(MedicamentStatus.NOT_DONE, medicament.getMedicamentId());
                }
            }
        } catch (PersistException e) {
            LOG.error("Can't cancel execute medicament", e);
            throw new ServiceException("Can't cancel execute medicament");
        }
    }

    @Override
    public boolean executeMedicament(int medicamentId) {
        Medicament medicament = medicamentDAO.getMedicamentById(medicamentId);
        if (dateUtils.parse(medicament.getDateStartMedicament().toString()).before(new Date())
                && dateUtils.parse(medicament.getDateEndMedicament().toString()).after(new Date())) {

            try {
                medicamentDAO.updateMedicamentStatus(MedicamentStatus.DONE, medicamentId);
                if (journalService != null &&
                        appointmentService != null &&
                        healingService != null &&
                        hospitalCardService != null) {

                    Appointment appointment = appointmentService.getAppointmentByMedicamentId(medicamentId);
                    Healing healing = healingService.getHealingByAppointmentId(appointment.getAppointmentId());
                    HospitalCard hospitalCard = hospitalCardService.getHospitalCardById(healing.getHospitalCardId());

                    journalService.createJournal(new Journal(new Date(), hospitalCard.getPatientId(), "Execute medicament"));
                }
                return true;
            } catch (PersistException e) {
                LOG.error("Can't execute medicament", e);
                throw new ServiceException("Can't execute medicament");
            }
        }
        return false;
    }

    public boolean updateMedicament(Medicament medicament) {
        try {
            return medicamentDAO.updateMedicament(medicament);
        } catch (PersistException e) {
            LOG.error("Can't update medicament", e);
            throw new ServiceException("Can't update medicament");
        }
    }

    public int createMedicament(Medicament medicament) {
        try {
            return medicamentDAO.createMedicament(medicament);
        } catch (PersistException e) {
            LOG.error("Can't create medicament", e);
            throw new ServiceException("Can't create medicament");
        }
    }

    public Medicament getMedicamentById(int medicamentId) {
        try {
            return medicamentDAO.getMedicamentById(medicamentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get medicament by Id", e);
            throw new ServiceException("Can't get medicamment by Id");
        }
    }
}
