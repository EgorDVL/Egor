package web.controller.doctor;

import static util.ErrorMessage.*;

import org.apache.log4j.Logger;
import service.MedicamentService;

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
 * Created by Egor on 20.01.2017.
 */
@WebServlet("/ExecuteMedicament")
public class ExecuteMedicament extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ExecuteMedicament.class);
    private static final String ERROR_MESSAGE = "errorMessage";
    private MedicamentService medicamentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        medicamentService = (MedicamentService) servletContext.getAttribute("medicamentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Execute Medicament - start");

        int medicamentId = Integer.parseInt(req.getParameter("medicamentId"));
        if (!medicamentService.executeMedicament(medicamentId)) {
            errorMessageToExecuteMedicament(req, EXECUTE_MEDICAMENT);
        }
        resp.sendRedirect("PatientHealing?healingId=" + req.getParameter("healingId"));
        LOG.info("Execute Medicament - end");
    }

    private void errorMessageToExecuteMedicament(HttpServletRequest req, String errorMessage) throws IOException {
        req.getSession().setAttribute(ERROR_MESSAGE, errorMessage);
    }
}
