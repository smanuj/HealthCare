package com.example.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String contact_number;
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private String pincode;

	public Hospital() {
		super();
	}

	public Hospital(String name, String contact_number, String location, String pincode) {
		super();
		this.name = name;
		this.contact_number = contact_number;
		this.location = location;
		this.pincode = pincode;
	}

	public Hospital(int id, String name, String contact_number, String location, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.contact_number = contact_number;
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

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
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
		return "Hospital [id=" + id + ", name=" + name + ", contact_number=" + contact_number + ", location=" + location
				+ ", pincode=" + pincode + "]";
	}

	}


