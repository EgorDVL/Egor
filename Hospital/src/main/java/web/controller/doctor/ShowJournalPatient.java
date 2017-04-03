package web.controller.doctor;

import static util.page.Page.*;

import bean.Journal;
import org.apache.log4j.Logger;
import service.JournalService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 25.01.2017.
 */
@WebServlet("/ShowJournalPatient")
public class ShowJournalPatient extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowJournalPatient.class);
    private JournalService journalService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        journalService = (JournalService) servletContext.getAttribute("journalService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show journal's patient - start");
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        List<Journal> journalList = journalService.getJournalPatient(patientId);
        req.setAttribute("journalList", journalList);
        req.getRequestDispatcher(SHOW_JOURNAL_PATIENT_PAGE).forward(req, resp);
        LOG.info("Show journal's patient - end");
    }
}
