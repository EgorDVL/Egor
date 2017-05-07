package com.zhyzhko.dao.impl;

import com.zhyzhko.dao.TypeDao;
import com.zhyzhko.dao.entity.Ttype;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
@Repository
public class TypeDaoImpl implements TypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Ttype createType(Ttype type) {
        Session session = sessionFactory.getCurrentSession();
        session.save(type);
        return type;
    }

    @Override
    public Ttype getType(int typeId) {
        Session session = sessionFactory.getCurrentSession();
        Ttype type = session.get(Ttype.class, typeId);
        return type;
    }

    @Override
    public List<Ttype> getAllType() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Ttype", Ttype.class).list();
    }

    @Override
    public boolean updateType(Ttype type) {
        Session session = sessionFactory.getCurrentSession();
        session.update(type);
        return true;
    }

    @Override
    public boolean deleteType(int typeId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete Ttype where id = :ID")
                .setParameter("ID", typeId)
                .executeUpdate() > 0;
    }
}
