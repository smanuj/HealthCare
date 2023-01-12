package com.valtech.health.app.model;

public class AvailabilityModel {

	private int id;
	private String hospitalName;
	private String location;
	private String doctorsAvailability;
	private String bedAvailability;

	public AvailabilityModel() {

	}

	public AvailabilityModel(int id,  String hospitalName,String location, String doctorsAvailability,
			String bedAvailability) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.location=location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
	}

	public AvailabilityModel( String hospitalName,String location, String doctorsAvailability,
			String bedAvailability) {
		super();

		this.hospitalName = hospitalName;
		this.location=location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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

	@Override
	public String toString() {
		return "AmbulanceModel [id=" + id + ",  hospitalName="
				+ hospitalName + ", location=" + location + ", doctorsAvailability=" + doctorsAvailability
				+ ", bedAvailability=" + bedAvailability + "]";
	}

	
}
