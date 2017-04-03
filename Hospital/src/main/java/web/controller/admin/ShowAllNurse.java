package web.controller.admin;

import bean.Nurse;
import org.apache.log4j.Logger;
import service.NurseService;
import service.impl.NurseServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.page.Page.SHOW_ALL_NURSES_PAGE;

/**
 * Created by Egor on 11.01.2017.
 */
@WebServlet("/ShowAllNurses")
public class ShowAllNurse extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllNurse.class);
    private NurseService nurseService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Show all nurse - start");
        List<Nurse> nurseList = nurseService.getAllNurses();
        req.setAttribute("nurseList", nurseList);
        req.getRequestDispatcher(SHOW_ALL_NURSES_PAGE).forward(req, resp);
        LOG.info("Show all doctors - end");
    }
}
