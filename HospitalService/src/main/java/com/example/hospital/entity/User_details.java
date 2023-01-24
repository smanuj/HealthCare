package com.example.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User_details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	
	@OneToOne(targetEntity=Doctor_details.class)
    @JoinColumn(name="doctordetails_id",referencedColumnName="id")
	private Doctor_details doctordetails;
	
	@OneToOne(targetEntity=Nurse_details.class)
    @JoinColumn(name="nursedetails_id",referencedColumnName="id")
	private Nurse_details nursedetails;
	
	
	public Nurse_details getNursedetails() {
		return nursedetails;
	}
	public void setNursedetails(Nurse_details nursedetails) {
		this.nursedetails = nursedetails;
	}
	
	
	public User_details(String email, String password, Nurse_details nursedetails) {
		super();
		this.email = email;
		this.password = password;
		this.nursedetails = nursedetails;
	}
	public User_details(String email, String password, Doctor_details doctordetails) {
		super();
		this.email = email;
		this.password = password;
		this.doctordetails = doctordetails;
	}
	public Doctor_details getDoctordetails() {
		return doctordetails;
	}
	public void setDoctordetails(Doctor_details doctordetails) {
		this.doctordetails = doctordetails;
	}
	public User_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_details(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public User_details(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "user_details [id=" + id + ", email=" + email + ", password=" + password + ", doctordetails="
				+ doctordetails + ", nursedetails=" + nursedetails + "]";
	}
	
	
	
	
	

}