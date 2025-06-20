package com.hibernate.ASSIGNMENT_1906;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AadharCard")
public class AadharCard {
	@Id
private int id;
private int Aadhar_num;

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getAadhar_num() {
	return Aadhar_num;
}

public void setAadhar_num(int aadhar_num) {
	Aadhar_num = aadhar_num;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "AadharCard [id=" + id + ", Aadhar_num=" + Aadhar_num + ", getId()=" + getId() + ", getAadhar_num()="
				+ getAadhar_num() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
