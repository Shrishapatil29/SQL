package com.hibernate.ASSIGNMENT_1906;


import javax.persistence.*;

@Entity
public class Wife {
    @Id
    private int id;
    private String name;

    @OneToOne(mappedBy = "wife")
    private Husband husband;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Husband getHusband() { return husband; }
    public void setHusband(Husband husband) { this.husband = husband; }
}
