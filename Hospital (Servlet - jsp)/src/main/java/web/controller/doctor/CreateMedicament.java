package web.controller.doctor;

import static util.ErrorMessage.*;

import bean.Medicament;
import org.apache.log4j.Logger;
import service.MedicamentService;
import service.impl.MedicamentServiceImpl;
import util.validators.CreateMedicamentValidator;
import util.validators.CreateOperationValidator;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.MedicamentRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static util.page.Page.CREATE_APPOINTMENT_PAGE;
import static util.page.Page.CREATE_MEDICAMENR_PAGE;

/**
 * Created by Egor on 16.01.2017.
 */
@WebServlet("/CreateMedicament")
public class CreateMedicament extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CreateMedicament.class);
    private static final String ERROR_MESSAGE = "errorMessage";

    private MedicamentService medicamentService;

    private HttpRequestConverter<Medicament> requestConverter = new MedicamentRequestConverter();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        medicamentService = (MedicamentService) servletContext.getAttribute("medicamentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create Medicament - clean Error message - start");
        HttpSession session = req.getSession();
        String errorMessage = (String) session.getAttribute(ERROR_MESSAGE);
        if (errorMessage != null) {
            session.removeAttribute(ERROR_MESSAGE);
            req.setAttribute(ERROR_MESSAGE, errorMessage);
        }
        LOG.info("Create Medicament - clean Error message - start");
        req.getRequestDispatcher(CREATE_MEDICAMENR_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Create medicament - start");
        HttpSession session = req.getSession();

        Medicament medicamentForm = requestConverter.fromRequest(req);

        if (CreateMedicamentValidator.nonEmpty(medicamentForm)) {
            errorMessageToCreateMedicament(resp, session, EMPTY_FIELD_ERROR);
            LOG.error("Empty field error");
            return;
        }
        if (CreateMedicamentValidator.validateDate(medicamentForm.getDateStartMedicament(), medicamentForm.getDateEndMedicament())) {
            errorMessageToCreateMedicament(resp, session, INCORRECT_DATE_MEDICAMENT);
            LOG.error("Incorrect date medicament");
            return;
        }

        int medicamentId = medicamentService.createMedicament(medicamentForm);

        if (String.valueOf(medicamentId) != null) {
            Medicament medicament = medicamentService.getMedicamentById(medicamentId);
            session.setAttribute("medicament", medicament);
        }

        session.setAttribute("medicamentId", String.valueOf(medicamentId));
        req.getRequestDispatcher(CREATE_APPOINTMENT_PAGE).forward(req, resp);
        LOG.info("Create Medicament - end");
    }

    private void errorMessageToCreateMedicament(HttpServletResponse resp, HttpSession session, String errorMessage) throws IOException {
        session.setAttribute(ERROR_MESSAGE, errorMessage);
        resp.sendRedirect("CreateMedicament");
    }
}
