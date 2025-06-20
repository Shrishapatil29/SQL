package com.hibernate.ASSIGNMENT_1906;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class APP_3 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure()
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Course.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Creating Courses
        Course c1 = new Course();
        c1.setId(101);
        c1.setName("Java");

        Course c2 = new Course();
        c2.setId(102);
        c2.setName("Python");

        // Creating Students
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shrisha");
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Aarohi");
        s2.getCourses().add(c1);

        // Save to DB
        session.save(c1);
        session.save(c2);
        session.save(s1);
        session.save(s2);

        tx.commit();

        // Fetch and Print
        System.out.println("\n--- List of Students and Their Courses ---");
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();

        for (Student student : students) {
            System.out.print("ID: " + student.getId() + ", Name: " + student.getName() + ", Courses: ");
            List<Course> courseList = student.getCourses();
            for (Course course : courseList) {
                System.out.print(course.getName() + " ");
            }
            System.out.println();
        }

        session.close();
        factory.close();
    }
}
