package web.controller.admin;

import bean.enums.PatientStatus;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.JournalService;
import service.PatientService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.ErrorMessage.CHOOSE_DOCTOR;
import static util.ErrorMessage.CHOOSE_PATIENT;
import static util.page.Page.MAIN_PAGE;

/**
 * Created by Egor on 13.01.2017.
 */
@WebServlet("/CreateAttendingDoctor")
public class CreateAttendingDoctor extends HttpServlet {
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOG = Logger.getLogger(CreateAttendingDoctor.class);

    private AttendingDoctorService attendingDoctorService;
    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        patientService = (PatientService) servletContext.getAttribute("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("clean Error message");

        LOG.info("Add patient to doctor - start");

        String patientId = (String) session.getAttribute("patientIdToAdd");
        session.removeAttribute("patientIdToAdd");

        String doctorId = (String) session.getAttribute("doctorIdToAdd");
        session.removeAttribute("doctorIdToAdd");

        if (patientId == null || patientId.isEmpty()) {
            errorMessageToPatientPage(resp, session, CHOOSE_PATIENT);
            LOG.error("Choose patient");
            return;
        }
        if (doctorId == null || doctorId.isEmpty()) {
            errorMessageToDoctorPage(resp, session, CHOOSE_DOCTOR);
            LOG.error("Choose doctor");
            return;
        }

        attendingDoctorService.createAttendingDoctor(Integer.parseInt(doctorId), Integer.parseInt(patientId));

        patientService.updatePatientStatus(Integer.parseInt(patientId), PatientStatus.TREATED);

        LOG.info("Create attending doctor - clean Error message");

        resp.sendRedirect("ShowAllPatient");
        LOG.info("Add patient to doctor - end");
    }

    private void errorMessageToPatientPage(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("ShowAllPatient");
    }

    private void errorMessageToDoctorPage(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("ShowAllDoctors");
    }
}
