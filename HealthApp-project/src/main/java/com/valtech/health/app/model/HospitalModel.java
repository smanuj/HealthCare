package com.valtech.health.app.model;

public class HospitalModel {
	private int id;
	private String hospitalname;
	private String contactnumber;

	public HospitalModel() {
		super();
	}

	public HospitalModel(int id, String hospitalname, String contactnumber) {
		super();
		this.id = id;
		this.hospitalname = hospitalname;
		this.contactnumber = contactnumber;
	}

	public HospitalModel(String hospitalname,  String contactnumber) {
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

	@Override
	public String toString() {
		return "HospitalModel [id=" + id + ", hospitalname=" + hospitalname 
				+ ", contactnumber=" + contactnumber + "]";
	}

}
