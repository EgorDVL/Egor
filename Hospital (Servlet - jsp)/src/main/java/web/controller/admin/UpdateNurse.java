package web.controller.admin;

import bean.Nurse;
import bean.Patient;
import org.apache.log4j.Logger;
import service.NurseService;
import web.requestConverter.HttpRequestConverter;
import web.requestConverter.impl.NurseRequestConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.page.Page.UPDATE_NURSE_PAGE;
import static util.page.Page.UPDATE_PATIENT_PAGE;

/**
 * Created by Egor on 02.02.2017.
 */
@WebServlet("/UpdateNurse")
public class UpdateNurse extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UpdateNurse.class);
    private NurseService nurseService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Get nurseId for update - start");
        int nurseId = Integer.parseInt(req.getParameter("nurseId"));
        Nurse nurse = nurseService.getNurseById(nurseId);

        req.setAttribute("nurse", nurse);

        LOG.info("Get nurseId for update - end");

        req.getRequestDispatcher(UPDATE_NURSE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Update nurse - start");
        int nurseId = Integer.parseInt(req.getParameter("nurseId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String specialty = req.getParameter("specialty");
        int experience = Integer.parseInt(req.getParameter("experience"));

        nurseService.updateNurse(nurseId, name, surname, phone, specialty, experience);
        LOG.info("Update nurse - end");
        resp.sendRedirect("ShowAllNurses");
    }
}
