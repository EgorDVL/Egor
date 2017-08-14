package com.zhyzhko.dao.HibirnateDao.impl;

import com.zhyzhko.dao.HibirnateDao.EmployeeDao;
import com.zhyzhko.dao.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by user on 06.07.17.
 */
@Repository
public class EmployeeDaoHibernate implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Employee createOrUpdate(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.saveOrUpdate(employee);
        return employee;
    }


    @Override
    public Employee getById(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, employeeId);
    }

    @Override
    public Optional<Employee> getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("from Employee where email = :EMAIL", Employee.class)
                .setParameter("EMAIL", email).uniqueResult());
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee ", Employee.class).getResultList();
    }


    @Override
    public List<Employee> getAllByDepartmentId(Integer departmentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee where departmentId = :DEPARTMENTID", Employee.class)
                .setParameter("DEPARTMENTID", departmentId)
                .getResultList();
    }


    @Override
    public boolean updateDepartmentId(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Employee set departmentId = null where id = :ID")
                .setParameter("ID", employee.getId()).executeUpdate();
        return true;
    }

    @Override
    public boolean delete(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete Employee where id= :ID").
                setParameter("ID", employeeId).
                executeUpdate() > 0;
    }
}