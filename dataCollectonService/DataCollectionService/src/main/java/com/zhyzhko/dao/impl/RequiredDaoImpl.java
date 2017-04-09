package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.RequiredDao;
import com.zhyzhko.dao.entity.Required;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class RequiredDaoImpl implements RequiredDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Required createRequired(Required required) {
        Session session = sessionFactory.getCurrentSession();
        session.save(required);
        return required;
    }

    @Override
    public Required getRequired(int requiredId) {
        Session session = sessionFactory.getCurrentSession();
        Required required = session.get(Required.class, requiredId);
        return required;
    }

    @Override
    public List<Required> getAllRequired() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Required", Required.class).list();
    }

    @Override
    public boolean updateRequired(Required required) {
        Session session = sessionFactory.getCurrentSession();
        session.update(required);
        return true;
    }

    @Override
    public boolean deleteRequired(int requiredId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(requiredId);
        return true;
    }
}
