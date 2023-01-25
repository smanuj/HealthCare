package com.login.service.entity;

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
	@Column(name = "hospitalId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int hospitalId;
	private String name;
	private String location;
	private String pincode;
	private boolean bedAvailabilty;

	public Hospital() {
		super();
	}

	public Hospital(String name, String location, String pincode, boolean bedAvailabilty) {
		super();
		this.name = name;
		this.location = location;
		this.pincode = pincode;
		this.bedAvailabilty = bedAvailabilty;

	}

	public Hospital(int hospitalId, String name, String location, String pincode, boolean bedAvailabilty) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
		this.pincode = pincode;
		this.bedAvailabilty = bedAvailabilty;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isBedAvailabilty() {
		return bedAvailabilty;
	}

	public void setBedAvailabilty(boolean bedAvailabilty) {
		this.bedAvailabilty = bedAvailabilty;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", name=" + name + ", location=" + location + ", pincode="
				+ pincode + ", bedAvailabilty=" + bedAvailabilty + "]";
	}
	
	


}


