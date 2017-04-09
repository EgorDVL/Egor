package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.FieldDao;
import com.zhyzhko.dao.entity.Field;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class FieldDaoImpl implements FieldDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Field createField(Field field) {
        Session session = sessionFactory.getCurrentSession();
        session.save(field);
        return field;
    }

    @Override
    public Field getField(int fieldId) {
        Session session = sessionFactory.getCurrentSession();
        Field field = session.get(Field.class, fieldId);
        return field;
    }

//    @Transactional
    @Override
    public List<Field> getAllField() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Field", Field.class).getResultList();
    }

    @Override
    public boolean updateField(Field field) {
        Session session = sessionFactory.getCurrentSession();
        session.update(field);
        return true;
    }

    @Override
    public boolean deleteField(int fieldId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fieldId);
        return true;
    }
}