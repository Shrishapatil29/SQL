package com.hibernate.ASSIGNMENT_1906;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    private int id;
    private String name;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
