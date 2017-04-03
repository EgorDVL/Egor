package service.impl;

import bean.Department;
import db.dao.DepartmentDAO;
import db.exception.ObtainObjectException;
import db.exception.ServiceException;
import org.apache.log4j.Logger;
import service.DepartmentService;

import java.util.List;

/**
 * Created by Egor on 09.01.2017.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger LOG = Logger.getLogger(DepartmentServiceImpl.class);
    private DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public List<Department> getAllDepartment() {
        try {
            return departmentDAO.getAllDepartments();
        } catch (ObtainObjectException e) {
            LOG.error("Can't get all Department", e);
            throw new ServiceException("Can't get all departments");
        }
    }

    public Department getDepartmentById(int departmentId) {
        try {
            return departmentDAO.getDepartmentById(departmentId);
        } catch (ObtainObjectException e) {
            LOG.error("Can't get Department by id", e);
            throw new ServiceException("Can't get department by Id");
        }
    }
}