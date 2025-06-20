package com.hibernate.ASSIGNMENT_1906;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person p1=new Person();
        p1.setId(2);
        p1.setName("Shrisha");
        
        Person p2=new Person();
        p2.setId(3);
        p2.setName("Sourabh");
        
        AadharCard a1=new AadharCard();
        a1.setId(102);
        a1.setAadhar_num(12345678);
        
        AadharCard a2=new AadharCard();
        a2.setId(103);
        a2.setAadhar_num(10001000);
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(AadharCard.class);
        
        
        SessionFactory sf = cfg.buildSessionFactory();

        // Open Session
        Session session = sf.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        session.save(p1);
        session.save(p2);
        session.save(a1);
        session.save(a2);

        tx.commit();

        // Close session and factory
        session.close();
        sf.close();
        

        System.out.println("Data saved successfully.");
    }
}
