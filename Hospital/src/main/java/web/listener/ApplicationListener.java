package web.listener;

import bean.enums.UserRole;
import db.TransactionProxyManager;
import db.dao.*;
import db.dao.impl.*;
import org.apache.log4j.Logger;
import service.*;
import service.impl.*;
import util.CreateReleasePDF;
import util.DateUtils;
import web.security.AuthenticationManager;
import web.security.SecurityContextParser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Egor on 09.01.2017.
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    public static final Logger LOG = Logger.getLogger(ApplicationListener.class);
    private DateUtils dateUtils;

    private AdminDAO adminDAO;
    private AppointmentDAO appointmentDAO;
    private AttendingDoctorDAO attendingDoctorDAO;
    private DepartmentDAO departmentDAO;
    private DiagnosisDAO diagnosisDAO;
    private DoctorDAO doctorDAO;
    private HealingDAO healingDAO;
    private HospitalCardDAO hospitalCardDAO;
    private MedicamentDAO medicamentDAO;
    private NurseDAO nurseDAO;
    private OperationsDAO operationsDAO;
    private PatientDAO patientDAO;
    private ProceduresDAO proceduresDAO;
    private UserDAO userDAO;
    private JournalDAO journalDAO;

    private DepartmentService departmentService;
    private DoctorService doctorService;
    private NurseService nurseService;
    private PatientService patientService;
    private UserService userService;
    private HospitalCardService hospitalCardService;
    private HealingService healingService;
    private DiagnosisService diagnosisService;
    private AppointmentService appointmentService;
    private OperationService operationService;
    private MedicamentService medicamentService;
    private ProceduresService proceduresService;
    private AttendingDoctorService attendingDoctorService;
    private JournalService journalService;

    private AuthenticationManager authenticationManager;

    private CreateReleasePDF createReleasePDF;


    private static final String PERMISSIONS_MAP = "permissions";
    private SecurityContextParser securityContextParser;

    public ApplicationListener() throws ParserConfigurationException {
        this.securityContextParser = new SecurityContextParser();
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Start of initialization of application context");
        ServletContext servletContext = sce.getServletContext();
        initDaoLayer(servletContext);
        initServiceLayer(servletContext);
        initAuthenticationManager(servletContext);
        initDateUtils(servletContext);

        initCreateReleasePDF(servletContext);

        sce.getServletContext().setAttribute(PERMISSIONS_MAP,
                initSecurityContext(sce));

        runCancelExecuteMedicamentsAndProceduresJobs();
    }

    private Map<UserRole, List<String>> initSecurityContext(
            ServletContextEvent event) {
        LOG.info("Init permissions map...");
        String securityContextPath = event.getServletContext()
                .getInitParameter("SecurityContextPath");
        String realpath = event.getServletContext().getRealPath(
                securityContextPath);
        return securityContextParser.parseSecurityContext(realpath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Destroy application context");
    }

    private void initDaoLayer(ServletContext servletContext) {
        LOG.info("Start of initialization of DAO layer...");

        adminDAO = new AdminDAOimpl();
        appointmentDAO = new AppointmentDAOimpl();
        attendingDoctorDAO = new AttendingDoctorDAOimpl();
        departmentDAO = new DepartmentDAOimpl();
        diagnosisDAO = new DiagnosisDAOimpl();
        doctorDAO = new DoctorDAOimpl();
        healingDAO = new HealingDAOimpl();
        hospitalCardDAO = new HospitalCardDAOimpl();
        medicamentDAO = new MedicamentDAOimpl();
        nurseDAO = new NurseDAOimpl();
        operationsDAO = new OperationsDAOimpl();
        patientDAO = new PatientDAOimpl();
        proceduresDAO = new ProceduresDAOimpl();
        userDAO = new UserDAOimpl();
        journalDAO = new JournalDAOimpl();
    }

    private void initServiceLayer(ServletContext servletContext) {
        LOG.info("Start of initialization of service layer...");

        journalService = TransactionProxyManager.getTransactionalWrapper(new JournalServiceImpl(journalDAO));
        departmentService = TransactionProxyManager.getTransactionalWrapper(new DepartmentServiceImpl(departmentDAO));
        nurseService = TransactionProxyManager.getTransactionalWrapper(new NurseServiceImpl(nurseDAO));
        userService = TransactionProxyManager.getTransactionalWrapper(new UserServiceImpl(userDAO));
        hospitalCardService = TransactionProxyManager.getTransactionalWrapper(new HospitalCardServiceImpl(hospitalCardDAO));
        healingService = TransactionProxyManager.getTransactionalWrapper(new HealingServiceImpl(healingDAO));
        diagnosisService = TransactionProxyManager.getTransactionalWrapper(new DiagnosisServiceImpl(diagnosisDAO));
        appointmentService = TransactionProxyManager.getTransactionalWrapper(new AppointmentServiceImpl(appointmentDAO));
        patientService = TransactionProxyManager.getTransactionalWrapper(new PatientServiceImpl(patientDAO));
        doctorService = TransactionProxyManager.getTransactionalWrapper(new DoctorServiceImpl(doctorDAO));

        operationService = TransactionProxyManager.getTransactionalWrapper(new OperationsServiceImpl(operationsDAO,
                journalService, appointmentService, healingService, hospitalCardService));

        medicamentService = TransactionProxyManager.getTransactionalWrapper(new MedicamentServiceImpl(medicamentDAO,
                journalService, appointmentService, healingService, hospitalCardService));

        proceduresService = TransactionProxyManager.getTransactionalWrapper(new ProceduresServiceImpl(proceduresDAO,
                journalService, appointmentService, healingService, hospitalCardService));

        attendingDoctorService = TransactionProxyManager.getTransactionalWrapper(new AttendingDoctorServiceImpl(attendingDoctorDAO));

        servletContext.setAttribute("departmentService", departmentService);
        servletContext.setAttribute("doctorService", doctorService);
        servletContext.setAttribute("nurseService", nurseService);
        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("hospitalCardService", hospitalCardService);
        servletContext.setAttribute("healingService", healingService);
        servletContext.setAttribute("diagnosisService", diagnosisService);
        servletContext.setAttribute("appointmentService", appointmentService);
        servletContext.setAttribute("operationService", operationService);
        servletContext.setAttribute("medicamentService", medicamentService);
        servletContext.setAttribute("proceduresService", proceduresService);
        servletContext.setAttribute("attendingDoctorService", attendingDoctorService);
        servletContext.setAttribute("journalService", journalService);
        servletContext.setAttribute("patientService", patientService);
    }

    private void initAuthenticationManager(ServletContext servletContext) {
        authenticationManager = new AuthenticationManager(userService);
        servletContext.setAttribute("authenticationManager", authenticationManager);
    }

    private void initCreateReleasePDF(ServletContext servletContext) {
        createReleasePDF = new CreateReleasePDF(
                patientService, hospitalCardService,
                healingService, diagnosisService, appointmentService,
                operationService, medicamentService, proceduresService);
        servletContext.setAttribute("createReleasePDF", createReleasePDF);
    }

    private void initDateUtils(ServletContext servletContext) {
        dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);
        servletContext.setAttribute("dateUtils", dateUtils);
    }

    private void runCancelExecuteMedicamentsAndProceduresJobs() {
        ScheduledExecutorService executorService = Executors
                .newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay((Runnable) () -> medicamentService.cancelExecuteMedicament(), 0, 1, TimeUnit.DAYS);
        executorService.scheduleWithFixedDelay((Runnable) () -> proceduresService.cancelExecuteProcedures(), 0, 1, TimeUnit.DAYS);
    }
}