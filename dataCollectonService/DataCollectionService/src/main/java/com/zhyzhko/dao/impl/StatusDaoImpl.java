package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.StatusDao;
import com.zhyzhko.dao.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class StatusDaoImpl implements StatusDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Status createStatus(Status status) {
        Session session = sessionFactory.getCurrentSession();
        session.save(status);
        return status;
    }

    @Override
    public Status getStatus(int statusId) {
        Session session = sessionFactory.getCurrentSession();
        Status status = session.get(Status.class, statusId);
        return status;
    }

    @Override
    public List<Status> getAllStatus() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Status", Status.class).list();
    }

    @Override
    public boolean updateStatus(Status status) {
        Session session = sessionFactory.getCurrentSession();
        session.update(status);
        return true;
    }

    @Override
    public boolean deleteStatus(int statusId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(statusId);
        return true;
    }
}
