package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.TypeValueDao;
import com.zhyzhko.dao.entity.TypeValue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class TypeValueDaoImpl implements TypeValueDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TypeValue createTypeValue(TypeValue typeValue) {
        Session session = sessionFactory.getCurrentSession();
        session.save(typeValue);
        return typeValue;
    }

    @Override
    public TypeValue getTypeValue(int typeValueId) {
        Session session = sessionFactory.getCurrentSession();
        TypeValue typeValue = session.get(TypeValue.class, typeValueId);
        return typeValue;
    }

    @Override
    public List<TypeValue> getAllTypeValue() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TypeValue", TypeValue.class).list();
    }

    @Override
    public boolean updateTypeValue(TypeValue typeValue) {
        Session session = sessionFactory.getCurrentSession();
        session.update(typeValue);
        return true;
    }

    @Override
    public boolean deleteTypeValue(int typeValueId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(typeValueId);
        return true;
    }
}