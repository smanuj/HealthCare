package com.mail.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToOne(targetEntity = Hospital.class)
	@JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId")
	private Hospital hospitalId;
	@OneToOne(targetEntity = Comments.class)
	@JoinColumn(name = "commentId", referencedColumnName = "commentId")
	private Comments commentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AadharDetails getAadharno() {
		return aId;
	}

	public void setAadharno(AadharDetails aadharno) {
		this.aId = aadharno;
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

	public Comments getCommentId() {
		return commentId;
	}

	public void setCommentId(Comments commentId) {
		this.commentId = commentId;
	}

	public PatientDetails() {
		super();
	}

	public PatientDetails(int id, AadharDetails aadharno, String bloodgroup, String pulse_rate, String oxygenlevel,
			String temperature, String disease, String pincode, NurseDetails nurseId, DoctorDetails doctorId,
			Comments commentId) {
		super();
		this.id = id;
		this.aId = aadharno;
		this.bloodgroup = bloodgroup;
		this.pulse_rate = pulse_rate;
		this.oxygenlevel = oxygenlevel;
		this.temperature = temperature;
		this.disease = disease;
		this.pincode = pincode;
		this.status = false;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.commentId = commentId;
	}

	public PatientDetails(AadharDetails aadharno, String bloodgroup, String pulse_rate, String oxygenlevel,
			String temperature, String disease, String pincode, NurseDetails nurseId, DoctorDetails doctorId,
			Comments commentId) {
		super();
		this.aId = aadharno;
		this.bloodgroup = bloodgroup;
		this.pulse_rate = pulse_rate;
		this.oxygenlevel = oxygenlevel;
		this.temperature = temperature;
		this.disease = disease;
		this.pincode = pincode;
		this.status = false;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.commentId = commentId;
	}

}
