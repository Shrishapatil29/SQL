package com.hibernate.ASSIGNMENT_1906;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_2 {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Department.class)
                                               .addAnnotatedClass(Employee.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Department d1 = new Department("Computer Science");

        Employee e1 = new Employee("Akshata", d1);
        Employee e2 = new Employee("Riya", d1);
        Employee e3 = new Employee("Shruti", d1);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        d1.setEmployees(list);

        Transaction tx = session.beginTransaction();
        session.save(d1); // Cascade saves employees too
        tx.commit();

        session.close();
        factory.close();
        System.out.println("Data inserted successfully.");
    }
}
