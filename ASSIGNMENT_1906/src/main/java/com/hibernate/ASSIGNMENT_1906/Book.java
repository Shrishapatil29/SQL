package com.hibernate.ASSIGNMENT_1906;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    private int id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")  // foreign key in book table
    private Author author;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}
