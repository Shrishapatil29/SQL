package com.hibernate.ASSIGNMENT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        int eid = 1;              // Student ID to update
        int newSalary = 10000;    // New salary (marks)

        // Step 1: Create Configuration and load settings
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Stud.class);

        // Step 2: Build SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Step 3: Open Session
        Session session = sf.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 5: Fetch the student object by ID
        Stud stud = session.get(Stud.class, eid);

        // Step 6: Update if found
        if (stud != null) {
            stud.setSalary(newSalary);  // Update salary
            System.out.println("Salary updated successfully for ID " + eid);
        } else {
            System.out.println("Student with ID " + eid + " not found.");
        }

        // Step 7: Commit and close session
        tx.commit();
        session.close();
        sf.close();
    }
}
