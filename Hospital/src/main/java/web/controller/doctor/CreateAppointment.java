package web.controller.doctor;

import bean.Appointment;
import org.apache.log4j.Logger;
import service.AppointmentService;
import service.impl.AppointmentServiceImpl;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.AppointmentRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.CREATE_HEALING_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateAppointment")
public class CreateAppointment extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CreateAppointment.class);
    private AppointmentService appointmentService;
    private HttpRequestConverter<Appointment> requestConverter = new AppointmentRequestConverter();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        appointmentService = (AppointmentService) servletContext.getAttribute("appointmentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create appointment - start");
        HttpSession session = req.getSession();

        Appointment appointment = requestConverter.fromRequest(req);

        int appointmentId = appointmentService.createAppointment(appointment);

        session.setAttribute("appointmentId", appointmentId);

        session.removeAttribute("operationId");
        session.removeAttribute("medicamentId");
        session.removeAttribute("proceduresId");

        session.removeAttribute("operations");
        session.removeAttribute("medicament");
        session.removeAttribute("procedures");


        req.getRequestDispatcher(CREATE_HEALING_PAGE).forward(req, resp);
        LOG.info("Create appointment - end");
    }
}