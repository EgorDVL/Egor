package web.controller.admin;

import bean.Nurse;
import bean.enums.DepartmentEnum;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Egor on 19.01.2017.
 */
@WebServlet("/TransferNurseDepartment")
public class TransferNurseDepartment extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowAllDepartments.class);
    private NurseService nurseService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        nurseService = (NurseService) servletContext.getAttribute("nurseService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Transfer nurse to another department - start");
        HttpSession session = req.getSession();

        int nurseId = Integer.parseInt(req.getParameter("nurseId"));
        String department = req.getParameter("department");
        Nurse nurse = nurseService.getNurseById(nurseId);

        Nurse nurseNew = new Nurse(nurseId, nurse.getName(), nurse.getSurname(), nurse.getPhone(),
                nurse.getSpecialty(), nurse.getDateOfBirth(), nurse.getExperience(), nurse.getPhoto(), DepartmentEnum.getValue(department), nurse.getUserId());

        nurseService.updateNurseTransfer(nurseNew);

        String prevPage = (String) session.getAttribute("previousPageNurse");
        resp.sendRedirect(prevPage);
        LOG.info("Transfer nurse to another department - end");
    }
}
