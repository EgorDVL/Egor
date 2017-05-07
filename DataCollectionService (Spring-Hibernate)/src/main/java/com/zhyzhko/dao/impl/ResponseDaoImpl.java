package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.ResponseDao;
import com.zhyzhko.dao.entity.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class ResponseDaoImpl implements ResponseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Response createResponse(Response response) {
        Session session = sessionFactory.getCurrentSession();
        session.save(response);
        return response;
    }

    @Override
    public Response getResponse(int responseId) {
        Session session = sessionFactory.getCurrentSession();
        Response response = session.get(Response.class, responseId);
        return response;
    }

    @Override
    public List<Response> getAllResponse() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Response", Response.class).list();
    }

    @Override
    public boolean updateResponse(Response response) {
        Session session = sessionFactory.getCurrentSession();
        session.update(response);
        return true;
    }

    @Override
    public boolean deleteResponse(int responseId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete Response where id = :ID")
                .setParameter("ID", responseId)
                .executeUpdate() > 0;
    }
}
