package web.controller.doctor;

import bean.Healing;
import bean.HospitalCard;
import bean.Patient;
import bean.enums.PatientStatus;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.HealingService;
import service.HospitalCardService;
import service.PatientService;
import util.CreateReleasePDF;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static util.ErrorMessage.RELEASE_PATIENT;

/**
 * Created by Egor on 26.01.2017.
 */
@WebServlet("/ReleasePatient")
public class ReleasePatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ReleasePatient.class);
    private static final String ERROR_MESSAGE = "errorMessage";

    private AttendingDoctorService attendingDoctorService;
    private PatientService patientService;
    private HospitalCardService hospitalCardService;
    private HealingService healingService;
    CreateReleasePDF createReleasePDF;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        hospitalCardService = (HospitalCardService) servletContext.getAttribute("hospitalCardService");
        healingService = (HealingService) servletContext.getAttribute("healingService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        createReleasePDF = (CreateReleasePDF) servletContext.getAttribute("createReleasePDF");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Release patient and change status to DISCHARGE - start");
        HttpSession session = req.getSession();
        int patientId = Integer.parseInt(req.getParameter("patientId"));

        HospitalCard hospitalCard = hospitalCardService.getHospitalCardByPatientId(patientId);
        Healing healing = healingService.getLastPatientHealing(hospitalCard.getHospitalCardId());

        if (healing != null && (healing.getDateHealingEnd().before(new Date()) ||
                DateUtils.isSameDay(new Date(), healing.getDateHealingEnd()))) {
            patientService.updatePatientStatus(patientId, PatientStatus.DISCHARGE);

            //delete patient from attending doctor
            attendingDoctorService.deleteAttendingDoctorByPatientId(patientId);
            createReleasePDF.createRelease(patientId);
        } else {
            errorMessageToPatientPage(session, RELEASE_PATIENT);
        }
        resp.sendRedirect("ShowMyPatients");
        LOG.info("Release patient and change status to DISCHARGE - end");
    }

    private void errorMessageToPatientPage(HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
    }
}
