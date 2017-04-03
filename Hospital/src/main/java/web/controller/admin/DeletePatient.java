package web.controller.admin;

import bean.Healing;
import bean.HospitalCard;
import bean.Patient;
import org.apache.log4j.Logger;
import service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 26.01.2017.
 */
@WebServlet("/DeletePatient")
public class DeletePatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(DeletePatient.class);

    private PatientService patientService;
    private AttendingDoctorService attendingDoctorService;
    private HospitalCardService hospitalCardService;
    private HealingService healingService;
    private UserService userService;
    private JournalService journalService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
        healingService = (HealingService) servletContext.getAttribute("healingService");
        userService = (UserService) servletContext.getAttribute("userService");
        journalService = (JournalService) servletContext.getAttribute("journalService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Delete patient by id - start");
        int patientId = Integer.parseInt(req.getParameter("patientId"));

        Patient patient = patientService.getPatientById(patientId);
        int patientUserId = patient.getUserId();

        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patientId);
        List<Healing> healingList = healingService.getAllHealingByHospitalCard(hospitalCard.getHospitalCardId());

        attendingDoctorService.deleteAttendingDoctorByPatientId(patientId);//delete attendingDoctor
        for (Healing healing : healingList) {
            healingService.deleteHealingById(healing.getHealingId());// delete healing
        }
        hospitalCardService.deleteHospitalCardById(hospitalCard.getHospitalCardId()); //delete hospital card
        patientService.deletePatientById(patientId);//delete patient

        userService.deleteUserById(patientUserId); // delete user
        journalService.deleteJournalBtPatientId(patientUserId);// delete patient's journal

        resp.sendRedirect("ShowAllPatient");
        LOG.info("Delete patient by id - end");
    }
}
