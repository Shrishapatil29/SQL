package com.hibernate.ASSIGNMENT_1906;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	@Id
private int id;
private String name;

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

public AadharCard getAadhar() {
	return aadhar;
}

public void setAadhar(AadharCard aadhar) {
	this.aadhar = aadhar;
}
@OneToOne
@JoinColumn(name="adhar_Id")
private AadharCard aadhar;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", aadhar=" + aadhar + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAadhar()=" + getAadhar() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
