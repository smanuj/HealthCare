package com.doctor.service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Hospital {
	@Id
	@Column(name = "hospitalId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	private String name;
	private String location;
	private String pincode;
	private boolean bedAvailabilty;
//	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	@JoinTable(name = "doctorHospitalMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "hospitalId"))

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

}
