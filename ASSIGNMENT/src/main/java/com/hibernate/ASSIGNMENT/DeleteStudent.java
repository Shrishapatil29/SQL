package com.hibernate.ASSIGNMENT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        int eid = 1;  // ID of the student to delete

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Stud.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Fetch the student by ID
        Stud stud = session.get(Stud.class, eid);

        if (stud != null) {
            session.delete(stud);  // delete if found
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + eid + " not found.");
        }

        tx.commit();
        session.close();
        sf.close();
    }
}
