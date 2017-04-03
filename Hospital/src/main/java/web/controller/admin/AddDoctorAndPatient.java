package web.controller.admin;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 13.01.2017.
 */
@WebServlet("/AddDoctorAndPatient")
public class AddDoctorAndPatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AddDoctorAndPatient.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Add patient to doctor - start");
        HttpSession session = req.getSession();

        int patientId = Integer.parseInt(req.getParameter("patientId"));
        session.setAttribute("patientIdToAdd", String.valueOf(patientId));
        resp.sendRedirect("ShowAllDepartments");

        LOG.info("Add patient to doctor - end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Add doctor to patient - start");
        HttpSession session = req.getSession();

        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        session.setAttribute("doctorIdToAdd", String.valueOf(doctorId));
        resp.sendRedirect("CreateAttendingDoctor");

        LOG.info("Add doctor to patient - end");
    }
}
