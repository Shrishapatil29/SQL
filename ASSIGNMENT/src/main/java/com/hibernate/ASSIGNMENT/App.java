package com.hibernate.ASSIGNMENT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Create object
        Stud stud = new Stud();
        stud.setEid(1);
        stud.setEname("Shrisha");
        stud.setSalary(50000);

        // Setup Hibernate
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // Save data
        session.beginTransaction();
        session.save(stud);
        session.getTransaction().commit();

        // Close
        session.close();
        sf.close();

        System.out.println("✅ Record inserted and table created successfully.");
    }
}
