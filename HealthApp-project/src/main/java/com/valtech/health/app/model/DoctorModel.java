package com.valtech.health.app.model;

public class DoctorModel {
	private int id;
	private String nursename;
	private String patients_name;
	private String doctor_comments;

	public DoctorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DoctorModel(String nursename, String patients_name, String doctor_comments) {
		super();
		this.nursename = nursename;
		this.patients_name = patients_name;
		this.doctor_comments = doctor_comments;
	}

	public DoctorModel(int id, String nursename, String patients_name, String doctor_comments) {
		super();
		this.id = id;
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

	public String getPatients_name() {
		return patients_name;
	}

	public void setPatients_name(String patients_name) {
		this.patients_name = patients_name;
	}

	public String getDoctor_comments() {
		return doctor_comments;
	}

	public void setDoctor_comments(String doctor_comments) {
		this.doctor_comments = doctor_comments;
	}

	@Override
	public String toString() {
		return "DoctorModel [id=" + id + ", nursename=" + nursename + ", patients_name=" + patients_name
				+ ", doctor_comments=" + doctor_comments + "]";
	}

	

	
}
