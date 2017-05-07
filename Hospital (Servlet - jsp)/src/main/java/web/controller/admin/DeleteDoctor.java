package web.controller.admin;

import bean.Doctor;
import org.apache.log4j.Logger;
import service.AttendingDoctorService;
import service.DoctorService;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Egor on 26.01.2017.
 */
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DeleteDoctor.class);

    private AttendingDoctorService attendingDoctorService;
    private DoctorService doctorService;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        attendingDoctorService = (AttendingDoctorService) servletContext.getAttribute("attendingDoctorService");
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
        userService = (UserService) servletContext.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Delete doctor by Id - start");
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));

        Doctor doctor = doctorService.getDoctorById(doctorId);
        int doctorUserId = doctor.getUserId();

        attendingDoctorService.deleteAttendingDoctorByDoctorId(doctorId);
        doctorService.deleteDoctorById(doctorId);
        userService.deleteUserById(doctorUserId);
        
        resp.sendRedirect("ShowAllDoctors");
        LOG.info("Delete doctor by Id - end");
    }
}
