package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.FieldResponseDao;
import com.zhyzhko.dao.entity.FieldResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class FieldResponseDaoImpl implements FieldResponseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public FieldResponse createFieldResponse(FieldResponse fieldResponse) {
        Session session = sessionFactory.getCurrentSession();
        session.save(fieldResponse);
        return fieldResponse;
    }

    @Override
    public FieldResponse getFieldResponse(int fieldResponseId) {
        Session session = sessionFactory.getCurrentSession();
        FieldResponse fieldResponse = session.get(FieldResponse.class, fieldResponseId);
        return fieldResponse;
    }

    @Override
    public List<FieldResponse> getAllFieldResponse() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from FieldResponse", FieldResponse.class).list();
    }

    @Override
    public boolean updateFieldResponse(FieldResponse fieldResponse) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fieldResponse);
        return true;
    }

    @Override
    public boolean deleteFieldResponse(int fieldResponseId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete FieldResponse where id = :ID")
                .setParameter("ID", fieldResponseId)
                .executeUpdate() > 0;
    }
}
