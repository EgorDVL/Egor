package web.controller.admin;

import bean.Doctor;
import bean.enums.DepartmentEnum;
import org.apache.log4j.Logger;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 19.01.2017.
 */
@WebServlet("/TransferDoctorDepartment")
public class TransferDoctorDepartment extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllDepartments.class);
    private DoctorService doctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Transfer doctor to another department - start");
        HttpSession session = req.getSession();
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        String department = req.getParameter("department");
        Doctor doctor = doctorService.getDoctorById(doctorId);

        Doctor doctorNew = new Doctor(doctorId, doctor.getName(), doctor.getSurname(), doctor.getPhone(), doctor.getSpecialty(),
                doctor.getDateOfBirth(), doctor.getExperience(), doctor.getPhoto(), DepartmentEnum.getValue(department), doctor.getUserId());
        doctorService.updateDoctorTransfer(doctorNew);

//        resp.sendRedirect(req.getHeader("referer"));
        String prevPage = (String) session.getAttribute("previousPageDoctor");
        resp.sendRedirect(prevPage);
        LOG.info("Transfer doctor to another department - end");
    }
}
