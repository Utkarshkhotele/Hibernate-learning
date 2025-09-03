package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()                  // looks for hibernate.cfg.xml in resources
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            System.out.println(" Hibernate connected successfully!");

            session.beginTransaction();
            Student s = new Student("Utkarsh");  // no manual id
            session.persist(s);                   // or session.save(s)
            session.getTransaction().commit();

            System.out.println(" Data inserted successfully! New ID = " + s.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
