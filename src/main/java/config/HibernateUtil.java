package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

        private static SessionFactory sessionFactory;

        static {
            try {

                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        // Method to get the current SessionFactory
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        // Method to close the SessionFactory (to release resources)
        public static void shutdown() {
            getSessionFactory().close();
        }

        // Method to get the current session
        public static Session getCurrentSession() {
            return sessionFactory.getCurrentSession();
        }

        // Method to open a new session
        public static Session openSession() {
            return sessionFactory.openSession();
        }
    }


