package ua.zerg.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.zerg.models.Car;
import ua.zerg.models.User;

/**
 * Factory Method for work with DB
 */
public class HibernateSessionFactoryUtil {

    // Static Instance of Session
    private static SessionFactory sessionFactory;

    // Private Constructor
    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {

        // Creating only one instance of our Factory
        if (sessionFactory == null) {
            try {

                // Creating new Configuration
                Configuration configuration = new Configuration().configure();
                // add Classes "User" and "Car" to our Configuration
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Car.class);
                // Getting Properties from "hibernate.cfg.xml
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
