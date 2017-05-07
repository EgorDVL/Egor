package web.controller.admin;

import bean.Doctor;
import bean.Patient;
import org.apache.log4j.Logger;
import service.DoctorService;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.DoctorRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.UPDATE_DOCTOR_PAGE;
import static util.page.Page.UPDATE_PATIENT_PAGE;

/**
 * Created by Egor on 02.02.2017.
 */
@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateDoctor.class);

    private DoctorService doctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get doctorId for update - start");

        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        Doctor doctor = doctorService.getDoctorById(doctorId);

        req.setAttribute("doctor", doctor);

        LOG.info("Get doctorId for update - end");

        req.getRequestDispatcher(UPDATE_DOCTOR_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update doctor - start");
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String specialty = req.getParameter("specialty");
        int experience = Integer.parseInt(req.getParameter("experience"));

        doctorService.updateDoctor(doctorId, name, surname, phone, specialty, experience);
        LOG.info("Update doctor - end");
        resp.sendRedirect("ShowAllDoctors");
    }
}
