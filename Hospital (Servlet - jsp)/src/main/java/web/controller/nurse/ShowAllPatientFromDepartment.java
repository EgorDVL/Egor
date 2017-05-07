package web.controller.nurse;

import bean.Doctor;
import bean.Nurse;
import bean.Patient;
import bean.User;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;
import service.NurseService;
import service.PatientService;
import service.impl.AttendingDoctorServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.NurseServiceImpl;
import service.impl.PatientServiceImpl;

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

import static util.page.Page.PATIENTS_OUR_DEPARTMENTPAGE;

/**
 * Created by Egor on 20.01.2017.
 */
@WebServlet("/ShowAllPatientFromDepartment")
public class ShowAllPatientFromDepartment extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ShowAllPatientFromDepartment.class);
    private PatientService patientService;
    private AttendingDoctorService attendingDoctorService;
    private DoctorService doctorService;
    private NurseService nurseService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        patientService = (PatientService) servletContext.getAttribute("patientService");
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all patient in our departments - start");
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        Nurse nurse = nurseService.getNurseByUserId(user.getUserId());

        List<Doctor> doctorList = doctorService.getAllDoctorsByDepartmentId(nurse.getDepartment().getValue());

        List<Integer> patientsId = null;
        for (Doctor doctor : doctorList) {
            patientsId = attendingDoctorService.getAllPatientIdByDoctorId(doctor.getDoctorId());
        }

        List<Patient> patientList = new ArrayList<>();
        for (int patientId : patientsId) {
            patientList.add(patientService.getPatientById(patientId));
        }

        req.setAttribute("patientList", patientList);
        req.getRequestDispatcher(PATIENTS_OUR_DEPARTMENTPAGE).forward(req, resp);
        LOG.info("Show all patient in our departments - end");
    }
}
