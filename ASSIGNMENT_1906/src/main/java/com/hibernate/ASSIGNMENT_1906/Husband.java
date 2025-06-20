package com.hibernate.ASSIGNMENT_1906;


import javax.persistence.*;

@Entity
public class Husband {
    @Id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "wife_id")
    private Wife wife;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Wife getWife() { return wife; }
    public void setWife(Wife wife) { this.wife = wife; }
}
