package zhyzhko.spring.demo.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zhyzhko.spring.demo.dao.UserDao;
import zhyzhko.spring.demo.dao.entity.User;

import java.util.List;

/**
 * Created by Egor on 21.03.2017.
 */
@Repository
public class HibernateUserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public User getUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        return user;
    }

    @Override
    public User getUser(String email) {
        Session session = sessionFactory.getCurrentSession();
        User user = session
                .createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    @Override
    public boolean deleteUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("delete User where id = :ID")
                .setParameter("ID", userId)
                .executeUpdate() > 0;
    }

    @Override
    public boolean deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        return true;
    }

    @Override
    public List<User> getAllUsersInGroup(int groupId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where groupId = :groupId", User.class)
                .setParameter("groupId", groupId)
                .getResultList();
    }
}
