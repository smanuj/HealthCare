package com.valtech.health.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false, unique = true)
	private String hospitalname;
	private String contactnumber;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospital")
	private Availability availability;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int id, String hospitalname,  String contactnumber) {
		super();
		this.id = id;
		this.hospitalname = hospitalname;
		this.contactnumber = contactnumber;
	}

	public Hospital(String hospitalname,  String contactnumber) {
		super();
		this.hospitalname = hospitalname;
		this.contactnumber = contactnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	
	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalname=" + hospitalname + ", contactnumber="
				+ contactnumber + "]";
	}

}
