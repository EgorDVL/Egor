package web.controller.admin;

import bean.Doctor;
import org.apache.log4j.Logger;
import service.DoctorService;
import service.impl.DoctorServiceImpl;
import util.validators.CreateDoctorValidator;
import util.validators.RegistrationValidator;
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

import static util.ErrorMessage.*;
import static util.page.Page.CREATE_DOCTOR_PAGE;
import static util.page.Page.CREATE_USER_PAGE;
import static util.page.Page.MAIN_PAGE;

/**
 * Created by Egor on 11.01.2017.
 */
@WebServlet("/CreateDoctor")
public class CreateDoctor extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateDoctor.class);
    private HttpRequestConverter<Doctor> requestConverter = new DoctorRequestConverter();
    private static final String ERROR_MESSAGE = "errorMessage";

    private DoctorService doctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        doctorService = (DoctorService) servletContext.getAttribute("doctorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create doctor - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create doctor - clean Error message - start");
        req.getRequestDispatcher(CREATE_DOCTOR_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create Doctor - start");
        HttpSession session = req.getSession();
        Doctor doctor = requestConverter.fromRequest(req);

        if (CreateDoctorValidator.nonEmpty(doctor)) {
            errorMessageToCreateDoctor(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreateDoctorValidator.validateDate(doctor.getDateOfBirth())) {
            errorMessageToCreateDoctor(resp, session, INCORRECT_DATE_OF_BIRTH);
            LOG.error("Incorrect date of birth");
            return;
        }
        if (!CreateDoctorValidator.validateForm(doctor)) {
            errorMessageToCreateDoctor(resp, session, ILLEGAL_CHARACTER_ERROR);
            LOG.error("Illegal character error");
            return;
        }


        doctorService.createDoctor(doctor);
        resp.sendRedirect("ShowAllDoctors");
        LOG.info("Create Doctor - end");
    }

    private void errorMessageToCreateDoctor(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateDoctor");
    }
}
