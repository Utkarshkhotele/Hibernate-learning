//package util;
//
//import com.example.Student;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class HibernateUtil {
//    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//            cfg.addAnnotatedClass(Student.class);
//            ServiceRegistry registry = new StandardServiceRegistryBuilder()
//                    .applySettings(cfg.getProperties())
//                    .build();
//            return cfg.buildSessionFactory(registry);
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return SESSION_FACTORY;
//    }
//
//    public static void shutdown() {
//        getSessionFactory().close();
//    }
//}
