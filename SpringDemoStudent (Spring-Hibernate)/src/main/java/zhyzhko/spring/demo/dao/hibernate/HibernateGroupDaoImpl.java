package zhyzhko.spring.demo.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zhyzhko.spring.demo.dao.GroupDao;
import zhyzhko.spring.demo.dao.entity.Groupp;

import java.util.List;

/**
 * Created by Egor on 21.03.2017.
 */
@Repository
public class HibernateGroupDaoImpl implements GroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Groupp createGroup(Groupp group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
        return group;
    }

    @Override
    public Groupp getGroup(int groupId) {
        Session session = sessionFactory.getCurrentSession();
        Groupp group = session.get(Groupp.class, groupId);
        return group;
    }

    @Override
    public List<Groupp> getAllGroups() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Groupp", Groupp.class)
                .getResultList();
    }

    @Override
    public boolean updateGroup(Groupp group) {
        Session session = sessionFactory.getCurrentSession();
        session.update(group);
        return true;
    }

    @Override
    public boolean deleteGroup(int groupId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete Groupp where id = :ID")
                .setParameter("ID", groupId)
                .executeUpdate() > 0;
    }
}
