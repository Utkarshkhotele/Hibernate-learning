package com.example;

import com.example.model.Note;
import com.example.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // ---------------- CREATE ----------------
        Note note1 = new Note("Shopping", "Buy milk and eggs");
        session.save(note1);

        Note note2 = new Note("Work", "Finish Hibernate project");
        session.save(note2);

        // ---------------- READ ----------------
        Note n = session.get(Note.class, 1);
        System.out.println("Read Note: " + n);

        // ---------------- UPDATE ----------------
        n.setContent("Buy milk, eggs, and bread");
        session.update(n);

        // ---------------- DELETE ----------------
        // session.delete(n);

        // ---------------- 1. HQL Example ----------------
        Query<Note> hqlQuery = session.createQuery("from Note where title = :title", Note.class);
        hqlQuery.setParameter("title", "Work");
        List<Note> workNotes = hqlQuery.list();
        System.out.println("HQL Result: " + workNotes);

        // ---------------- 2. Criteria API Example ----------------
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Note> cq = cb.createQuery(Note.class);
        Root<Note> root = cq.from(Note.class);
        cq.select(root).where(cb.like(root.get("content"), "%milk%"));
        List<Note> milkNotes = session.createQuery(cq).getResultList();
        System.out.println("Criteria Result: " + milkNotes);

        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
