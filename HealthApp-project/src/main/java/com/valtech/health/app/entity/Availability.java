package com.valtech.health.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Availability {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String hospitalName;
	private String location;
	private String doctorsAvailability;
	private String bedAvailability;
	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name = "hospital_id", nullable = false)
	private Hospital hospital;

	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Availability(String hospitalName, String location, String doctorsAvailability, String bedAvailability,
			Hospital hospital) {
		super();
		this.hospitalName = hospitalName;
		this.location = location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
		this.hospital = hospital;
	}




	public Availability(int id, String hospitalName, String location, String doctorsAvailability,
			String bedAvailability, Hospital hospital) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.location = location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
		this.hospital = hospital;
	}




	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDoctorsAvailability() {
		return doctorsAvailability;
	}

	public void setDoctorsAvailability(String doctorsAvailability) {
		this.doctorsAvailability = doctorsAvailability;
	}

	public String getBedAvailability() {
		return bedAvailability;
	}

	public void setBedAvailability(String bedAvailability) {
		this.bedAvailability = bedAvailability;
	}
	

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Availability [id=" + id + ", hospitalName=" + hospitalName + ", location=" + location
				+ ", doctorsAvailability=" + doctorsAvailability + ", bedAvailability=" + bedAvailability
				+ ", hospital=" + hospital + "]";
	}

	
}
