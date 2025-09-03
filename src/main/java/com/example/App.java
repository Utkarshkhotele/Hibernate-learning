package com.example;

import com.example.model.Note;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        // CREATE
        int noteId = createNote("Shopping List", "Milk, Bread, Eggs");

        // READ
        readNote(noteId);

        // UPDATE
        updateNote(noteId, "Updated Shopping List", "Milk, Bread, Eggs, Butter");

        // DELETE
        deleteNote(noteId);

        HibernateUtil.shutdown();
    }

    // CREATE
    public static int createNote(String title, String content) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer noteId = null;

        try {
            tx = session.beginTransaction();
            Note note = new Note(title, content);
            noteId = (Integer) session.save(note);
            tx.commit();
            System.out.println("✅ Note created with ID: " + noteId);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return noteId;
    }

    // READ
    public static void readNote(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Note note = session.get(Note.class, id);
            if (note != null) {
                System.out.println("📖 Found: " + note);
            } else {
                System.out.println("⚠ No note found with ID " + id);
            }
        } finally {
            session.close();
        }
    }

    // UPDATE
    public static void updateNote(int id, String newTitle, String newContent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Note note = session.get(Note.class, id);
            if (note != null) {
                note.setTitle(newTitle);
                note.setContent(newContent);
                session.update(note);
                tx.commit();
                System.out.println("✏ Updated: " + note);
            } else {
                System.out.println("⚠ Cannot update. Note not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // DELETE
    public static void deleteNote(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Note note = session.get(Note.class, id);
            if (note != null) {
                session.delete(note);
                tx.commit();
                System.out.println("🗑 Deleted Note with ID " + id);
            } else {
                System.out.println("⚠ Cannot delete. Note not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
