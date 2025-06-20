package com.hibernate.ASSIGNMENT_1906;


import javax.persistence.*;
import java.util.*;

@Entity
public class Course {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}

