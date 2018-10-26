package ua.zerg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.zerg.models.Car;
import ua.zerg.models.User;
import ua.zerg.utils.HibernateSessionFactoryUtil;
import java.util.List;

/**
 * DAO Implementation
 * Make main operations to get, save, update
 * and delete data from DB
 * Uses Session Factory to connect to DB
 */
public class UserDaoImpl implements UserDao {

    public User findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<User> findAll() {
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From User").list();
    }

    public Car findCarById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Car.class, id);
    }
}
