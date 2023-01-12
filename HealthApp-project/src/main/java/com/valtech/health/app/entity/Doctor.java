package com.valtech.health.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DoctorsComments")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private String nursename;
	@Column(nullable = false)
	private String patients_name;
	@Column(nullable = false)
	private String doctor_comments;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String nursename, String patients_name, String doctor_comments) {
		super();
		this.id = id;
		this.nursename = nursename;
		this.patients_name = patients_name;
		this.doctor_comments = doctor_comments;
	}

	public Doctor(String nursename, String patients_name, String doctor_comments) {
		super();
		this.nursename = nursename;
		this.patients_name = patients_name;
		this.doctor_comments = doctor_comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getNursename() {
		return nursename;
	}

	public void setNursename(String nursename) {
		this.nursename = nursename;
	}

	public String getDoctor_comments() {
		return doctor_comments;
	}

	public void setDoctor_comments(String doctor_comments) {
		this.doctor_comments = doctor_comments;
	}

	public String getPatients_name() {
		return patients_name;
	}

	public void setPatients_name(String patients_name) {
		this.patients_name = patients_name;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nursename=" + nursename + ", patients_name=" + patients_name
				+ ", doctor_comments=" + doctor_comments + "]";
	}

}
