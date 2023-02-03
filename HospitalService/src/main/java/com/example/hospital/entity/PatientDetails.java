package com.example.hospital.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@OneToOne(targetEntity = AadharDetails.class)
	@JoinColumn(name = "aId", referencedColumnName = "aId")
	private AadharDetails aId;
	private String bloodgroup;
	private String pulse_rate;
	private String oxygenlevel;
	private String temperature;
	private String disease;
	private String pincode;
	private boolean status;
	@OneToOne(targetEntity = NurseDetails.class)
	@JoinColumn(name = "nurseId", referencedColumnName = "nurseId")
	private NurseDetails nurseId;
	@OneToOne(targetEntity = DoctorDetails.class)
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private DoctorDetails doctorId;
	@JsonBackReference
	@OneToMany(mappedBy = "patients")
    private Set<Comments> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AadharDetails getaId() {
		return aId;
	}
	public void setaId(AadharDetails aId) {
		this.aId = aId;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getPulse_rate() {
		return pulse_rate;
	}
	public void setPulse_rate(String pulse_rate) {
		this.pulse_rate = pulse_rate;
	}
	public String getOxygenlevel() {
		return oxygenlevel;
	}
	public void setOxygenlevel(String oxygenlevel) {
		this.oxygenlevel = oxygenlevel;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public NurseDetails getNurseId() {
		return nurseId;
	}
	public void setNurseId(NurseDetails nurseId) {
		this.nurseId = nurseId;
	}
	public DoctorDetails getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(DoctorDetails doctorId) {
		this.doctorId = doctorId;
	}
	public Set<Comments> getComments() {
		return comments;
	}
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
	public PatientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDetails(int id, AadharDetails aId, String bloodgroup, String pulse_rate, String oxygenlevel,
			String temperature, String disease, String pincode, boolean status, NurseDetails nurseId,
			DoctorDetails doctorId, Set<Comments> comments) {
		super();
		this.id = id;
		this.aId = aId;
		this.bloodgroup = bloodgroup;
		this.pulse_rate = pulse_rate;
		this.oxygenlevel = oxygenlevel;
		this.temperature = temperature;
		this.disease = disease;
		this.pincode = pincode;
		this.status = status;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.comments = comments;
	}
	public PatientDetails(AadharDetails aId, String bloodgroup, String pulse_rate, String oxygenlevel,
			String temperature, String disease, String pincode, boolean status, NurseDetails nurseId,
			DoctorDetails doctorId, Set<Comments> comments) {
		super();
		this.aId = aId;
		this.bloodgroup = bloodgroup;
		this.pulse_rate = pulse_rate;
		this.oxygenlevel = oxygenlevel;
		this.temperature = temperature;
		this.disease = disease;
		this.pincode = pincode;
		this.status = status;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.comments = comments;
	}
	public PatientDetails(String bloodgroup, String pulse_rate, String oxygenlevel, String temperature, String disease,
			String pincode, boolean status, NurseDetails nurseId, DoctorDetails doctorId) {
		super();
		this.bloodgroup = bloodgroup;
		this.pulse_rate = pulse_rate;
		this.oxygenlevel = oxygenlevel;
		this.temperature = temperature;
		this.disease = disease;
		this.pincode = pincode;
		this.status = status;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
	}
	
	
	
	
	
}
