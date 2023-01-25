package com.example.hospital.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String email;
	private String password;

	@OneToOne(targetEntity = DoctorDetails.class)
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private DoctorDetails doctorDetails;

	@OneToOne(targetEntity = NurseDetails.class)
	@JoinColumn(name = "nurseId", referencedColumnName = "nurseId")
	private NurseDetails nurseDetails;

	public NurseDetails getNursedetails() {
		return nurseDetails;
	}

	public void setNursedetails(NurseDetails nursedetails) {
		this.nurseDetails = nursedetails;
	}

	public UserDetails(String email, String password, NurseDetails nursedetails) {
		super();
		this.email = email;
		this.password = password;
		this.nurseDetails = nursedetails;
	}

	public UserDetails(String email, String password, DoctorDetails doctordetails) {
		super();
		this.email = email;
		this.password = password;
		this.doctorDetails = doctordetails;
	}

	public DoctorDetails getDoctordetails() {
		return doctorDetails;
	}

	public void setDoctordetails(DoctorDetails doctordetails) {
		this.doctorDetails = doctordetails;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserDetails(int id, String email, String password) {
		super();
		this.userId = id;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
