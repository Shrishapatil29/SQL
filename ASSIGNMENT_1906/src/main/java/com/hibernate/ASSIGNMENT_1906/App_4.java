package com.hibernate.ASSIGNMENT_1906;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_4 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure()
            .addAnnotatedClass(Husband.class)
            .addAnnotatedClass(Wife.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create Wife
        Wife w1 = new Wife();
        w1.setId(1);
        w1.setName("Shrisha");

        // Create Husband
        Husband h1 = new Husband();
        h1.setId(1);
        h1.setName("Rahul");

        // Link them
        h1.setWife(w1);
        w1.setHusband(h1);

        // Save both
        session.save(w1);  // save wife first to avoid constraint violation
        session.save(h1);

        tx.commit();

        // Fetch and display
        Husband h = session.get(Husband.class, 1);
        System.out.println("Husband Name: " + h.getName());
        System.out.println("Wife Name: " + h.getWife().getName());

        Wife w = session.get(Wife.class, 1);
        System.out.println("Wife Name: " + w.getName());
        System.out.println("Husband Name: " + w.getHusband().getName());

        session.close();
        factory.close();
    }
}
