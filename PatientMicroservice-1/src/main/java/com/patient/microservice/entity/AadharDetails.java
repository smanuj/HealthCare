package com.patient.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AadharDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private int aadharNo;
	private String name;
	private String phoneno;
	private String dob;
	private String gender;
	private String address;

	public int getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AadharDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AadharDetails(int aadharNo, String name, String phoneno, String dob, String gender, String address) {
		super();
		this.aadharNo = aadharNo;
		this.name = name;
		this.phoneno = phoneno;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
	}

}
