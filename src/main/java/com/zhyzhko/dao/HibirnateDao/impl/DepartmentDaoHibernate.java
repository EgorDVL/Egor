package com.zhyzhko.dao.HibirnateDao.impl;

import com.zhyzhko.dao.HibirnateDao.DepartmentDao;
import com.zhyzhko.dao.entity.Department;
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
public class DepartmentDaoHibernate implements DepartmentDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department createOrUpdate(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.saveOrUpdate(department);
        return department;
    }

    @Override
    public Department getById(Integer departmentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class, departmentId);
    }

    @Override
    public Optional<Department> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("from Department where name = :NAME", Department.class)
                .setParameter("NAME", name).uniqueResult());
    }

    @Override
    public List<Department> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Department order by id", Department.class).getResultList();
    }

    @Override
    public boolean delete(Integer departmentId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete Department where id= :ID")
                .setParameter("ID", departmentId)
                .executeUpdate() > 0;
    }
}
