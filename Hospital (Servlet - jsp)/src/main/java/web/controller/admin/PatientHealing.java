package web.controller.admin;

import bean.*;
import org.apache.log4j.Logger;
import service.*;
import service.impl.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.page.Page.HEALING_PATIENT_INFO_PAGE;

/**
 * Created by Egor on 19.01.2017.
 */
@WebServlet("/PatientHealing")
public class PatientHealing extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(PatientHealing.class);
    private static final String ERROR_MESSAGE = "errorMessage";

    private AttendingDoctorService attendingDoctorService;
    private HealingService healingService;
    private HospitalCardService hospitalCardService;
    private DiagnosisService diagnosisService;
    private AppointmentService appointmentService;
    private OperationService operationService;
    private MedicamentService medicamentService;
    private ProceduresService proceduresService;
    private DoctorService doctorService;

    public PatientHealing() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        healingService = (HealingService) servletContext.getAttribute("healingService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
        diagnosisService = (DiagnosisService) servletContext.getAttribute("diagnosisService");
        appointmentService = (AppointmentService) servletContext.getAttribute("appointmentService");
        operationService = (OperationService) servletContext.getAttribute("operationService");
        medicamentService = (MedicamentService) servletContext.getAttribute("medicamentService");
        proceduresService = (ProceduresService) servletContext.getAttribute("proceduresService");
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all healing info - start");
        LOG.info("Execute operation - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Execute operation - clean Error message - end");
        int healingId = Integer.parseInt(req.getParameter("healingId"));

        showAllPatientInfo(req, healingId);

        req.getRequestDispatcher(HEALING_PATIENT_INFO_PAGE).forward(req, resp);
        LOG.info("Show all healing info - end");
    }

    private void showAllPatientInfo(HttpServletRequest req, int healingId) {
        Healing healing = healingService.getHealingById(healingId);

        Diagnosis diagnosis = diagnosisService.getDiagnosisById(healing.getDiagnosisId());
        Appointment appointment = appointmentService.getAppointmentById(healing.getAppointmentId());
        Operation operation = operationService.getOperationById(appointment.getOperationId());
        Medicament medicament = medicamentService.getMedicamentById(appointment.getMedicamentId());
        Procedures procedures = proceduresService.getProceduresById(appointment.getProceduresId());

        //for show attendings doctors
        HospitalCard hospitalCard = hospitalCardService.getHospitalCardById(healing.getHospitalCardId());
        List<Integer> doctorsIdList = attendingDoctorService.getAllDoctorsIdByPatientId(hospitalCard.getPatientId());
        List<Doctor> doctorsList = new ArrayList<>();
        for (int doctorId : doctorsIdList) {
            doctorsList.add(doctorService.getDoctorById(doctorId));
        }

        req.setAttribute("healing", healing);
        req.setAttribute("doctorsList", doctorsList);
        req.setAttribute("diagnosis", diagnosis);
        req.setAttribute("appointment", appointment);
        req.setAttribute("operation", operation);
        req.setAttribute("medicament", medicament);
        req.setAttribute("procedures", procedures);
    }
}
