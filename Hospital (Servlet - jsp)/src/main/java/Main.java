import java.text.ParseException;

/**
 * Created by Egor on 05.01.2017.
 */

public class Main {
    public static void main(String[] args) throws ParseException, InterruptedException {

//        System.out.println(d1.getClass());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

//
//        String currentDate = format.format(new Date());
//
//        System.out.println(currentDate);
//        Date date = format.parse(currentDate);
//
//
//        System.out.println(date);
//        System.out.println(new Date());

//        Connection con = DBManager.getConnection();
//        User user = new User("vvv@mail.ru", "1111", UserRole.NURSE);

//        Date currentDate = new Date();
//        Admin admin = new Admin(4, "lol44", "lol44", Role.ADMIN);
//        Appointment appointment = new Appointment(3, "qqqhh", currentDate, 1, 2, 3);
//        AttendingDoctor attendingDoctor = new AttendingDoctor(2, 3, 1);
//        Department department = new Department(12, DepartmentEnum.NEUROLOGY);
//        Diagnosis diagnosis = new Diagnosis(4, "lwww");
//        Doctor doctor = new Doctor("Vasiliy", "Pupok", "+380502223311", "Sexolog", currentDate, 6, "sfsdfsdf.img", DepartmentEnum.GYNECOLOGY, 3);
//        Healing healing = new Healing(4,currentDate,currentDate,2,2,1);
//        HospitalCard hospitalCard = new HospitalCard(4,1);
//        Medicament medicament = new Medicament(4, "hyetenn", MedicamentEnum.PILLS, "2 times", currentDate, currentDate);
//        Nurse nurse = new Nurse(1, "Lol@mail.ru", "bbbb", "dfdfdf", "sdfsdfsdf", "+380502321123", "loshara", currentDate, 2, Role.NURSE, 2);
//        Operation operations = new Operation(3,"ololo",currentDate, ComplexityEnum.NORMAL);
//        Patient patient = new Patient(3,"EgorDVL@gmail.com","lololo","12345","Egor","Zhyzhko","+380502327070",currentDate,"st Tselinogradska h.58 f.203",Role.PATIENT);
//        Procedures procedures = new Procedures(3, "proced1", "2 times", currentDate, currentDate);
//        try {
//            System.out.println(DaoFactory.getPatientDAO().getSortedPatientByParam("surname", con));
//            DaoFactory.getUserDAO().createUser(user, con);
//            System.out.println(DaoFactory.getUserDAO().getUserById(1, con));

//            DaoFactory.getProceduresDAO().createProcedures(procedures, con);
//            System.out.println(DaoFactory.getProceduresDAO().getProceduresById(2, con));
//            System.out.println(DaoFactory.getProceduresDAO().getAllProcedures(con));
//            DaoFactory.getProceduresDAO().updateProcedures(procedures, con);

        //Patient
//            DaoFactory.getPatientDAO().createPatient(patient,con);
//            System.out.println(DaoFactory.getPatientDAO().getPatientById(1,con));
//            System.out.println(DaoFactory.getPatientDAO().getAllPatients(con));
//            DaoFactory.getPatientDAO().updatePatient(patient,con);

        //Operation
//            DaoFactory.getOperationsDAO().createOperations(operations,con);
//            System.out.println(DaoFactory.getOperationsDAO().getOperationsById(1,con));
//            System.out.println(DaoFactory.getOperationsDAO().getAllOperations(con));
//            DaoFactory.getOperationsDAO().updateOperations(operations,con);

        //Nurse
//            DaoFactory.getNurseDAO().createNurse(nurse, con);
//            System.out.println(DaoFactory.getNurseDAO().getNurseById(1,con));
//            System.out.println(DaoFactory.getNurseDAO().getAllNurses(con));
//            DaoFactory.getNurseDAO().updateNurse(nurse,con);

        //Medicament
//            DaoFactory.getMedicamentDAO().createMedicament(medicament,con);
//            System.out.println(DaoFactory.getMedicamentDAO().getMedicamentById(2, con));
//            System.out.println(DaoFactory.getMedicamentDAO().getAllMedicaments(con));
//            DaoFactory.getMedicamentDAO().updateMedicament(medicament,con);

        //HospitalCard
//            DaoFactory.getHospitalCardDAO().createHospitalCard(hospitalCard,con);
//            System.out.println(DaoFactory.getHospitalCardDAO().getHospitalCardById(1,con));
//            System.out.println(DaoFactory.getHospitalCardDAO().getAllHospitalCards(con));
//            DaoFactory.getHospitalCardDAO().updateHospitalCard(hospitalCard,con);

        //Healing
//            DaoFactory.getHealingDAO().createHealing(healing,con);
//            System.out.println(DaoFactory.getHealingDAO().getHealingById(1,con));
//            System.out.println(DaoFactory.getHealingDAO().getAllHealings(con));
//            DaoFactory.getHealingDAO().updateHealing(healing,con);

        //Doctor
//            DaoFactory.getDoctorDAO().createDoctor(doctor, con);
//            System.out.println(DaoFactory.getDoctorDAO().getDoctorById(1, con));
//            System.out.println(DaoFactory.getDoctorDAO().getAllDoctors(con));
//            DaoFactory.getDoctorDAO().updateDoctor(doctor, con);

        //Diagnosis
//            DaoFactory.getDiagnosisDAO().createDiagnosis(diagnosis, con);
//            System.out.println(DaoFactory.getDiagnosisDAO().getDiagnosisById(1, con));
//            System.out.println(DaoFactory.getDiagnosisDAO().getAllDiagnosis(con));
//            DaoFactory.getDiagnosisDAO().updateDiagnosis(diagnosis, con);

        //Departament
//            DaoFactory.getDepartmentDAO().createDepartment(department, con);
//            System.out.println(DaoFactory.getDepartmentDAO().getDepartmentById(1, con));
//            System.out.println(DaoFactory.getDepartmentDAO().getAllDepartments(con));
//            DaoFactory.getDepartmentDAO().updateDepartment(department, con);

        //AttendingDoctor
//            DaoFactory.getAttendingDoctorDAO().createAttendingDoctor(attendingDoctor, con);
//            System.out.println(DaoFactory.getAttendingDoctorDAO().getAttendingDoctorById(2, con));
//            System.out.println(DaoFactory.getAttendingDoctorDAO().getAllAttendingDoctors(con));
//            DaoFactory.getAttendingDoctorDAO().updateAttendingDoctor(attendingDoctor, con);


        //Appointment
//            DaoFactory.getAppointmentDAO().createAppointment(appointment, con);
//            System.out.println(DaoFactory.getAppointmentDAO().getAppointmentById(3,con));
//            System.out.println(DaoFactory.getAppointmentDAO().getAllAppointments(con));
//            DaoFactory.getAppointmentDAO().updateAppointment(appointment, con);

        //ADMIN
//            DaoFactory.getAdminDAO().createAdmin(admin, con);
//            System.out.println(DaoFactory.getAdminDAO().getAdminById(1, con));
//            System.out.println(DaoFactory.getAdminDAO().getAllAdmins(con));
//            DaoFactory.getAdminDAO().updateAdmin(admin, con);

//            DBManager.commit(con);
//        } catch (
//                SQLException e
//                )
//
//        {
//            DBManager.rollback(con);
//        } finally
//
//        {
//            DBManager.closeCon(con);
//        }
    }
}