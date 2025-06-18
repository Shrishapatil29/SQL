package com.hibernate.ASSIGNMENT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertStudent {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Stud.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Stud s1 = new Stud();
        s1.setEid(1);
        s1.setEname("Shrisha");
        s1.setSalary(5000); // initial marks

        session.save(s1);

        tx.commit();
        session.close();
        sf.close();

        System.out.println("Student inserted successfully.");
    }
}
