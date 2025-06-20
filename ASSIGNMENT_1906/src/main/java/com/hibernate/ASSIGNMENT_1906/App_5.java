package com.hibernate.ASSIGNMENT_1906;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_5 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure()
            .addAnnotatedClass(Author.class)
            .addAnnotatedClass(Book.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create Author
        Author author = new Author();
        author.setId(1);
        author.setName("Shrisha Patil");

        // Create Book 1
        Book b1 = new Book();
        b1.setId(101);
        b1.setTitle("Java for Beginners");
        b1.setAuthor(author);

        // Create Book 2
        Book b2 = new Book();
        b2.setId(102);
        b2.setTitle("Hibernate Mastery");
        b2.setAuthor(author);

        // Save author and books
        session.save(author);
        session.save(b1);
        session.save(b2);

        tx.commit();

        // Fetch and display books with authors
        System.out.println("\n--- Book Details ---");
        Book result = session.get(Book.class, 101);
        System.out.println("Title: " + result.getTitle() + ", Author: " + result.getAuthor().getName());

        session.close();
        factory.close();
    }
}
