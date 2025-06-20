package com.hibernate.ASSIGNMENT_1906;


import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
       return department;
    }

    public void setDepartment(Department department) {
       this.department = department;
    }
}
