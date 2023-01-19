package com.example.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitals")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String number;
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private String pincode;

	public Hospital() {
		super();
	}

	public Hospital(String name, String number, String location, String pincode) {
		super();
		this.name = name;
		this.number = number;
		this.location = location;
		this.pincode = pincode;
	}

	public Hospital(int id, String name, String number, String location, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.location = location;
		this.pincode = pincode;
	}

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

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", number=" + number + ", location=" + location + ", pincode="
				+ pincode + "]";
	}


	}


