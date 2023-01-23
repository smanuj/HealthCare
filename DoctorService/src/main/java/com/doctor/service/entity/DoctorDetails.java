package com.doctor.service.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class DoctorDetails {

	@Id
	@Column(name = "doctorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String name;
	private String pnumber;
	private String specialization;
	private boolean avaliability;
	private boolean approval;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "doctorHospitalMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "hospitalId"))
	private Set<Hospital> hospitals;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public boolean isAvaliability() {
		return avaliability;
	}

	public void setAvaliability(boolean avaliability) {
		this.avaliability = avaliability;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public Set<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(Set<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDetails(int doctorId, String name, String pnumber, String specialization, boolean avaliability,
			boolean approval, Set<Hospital> hospitals) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.pnumber = pnumber;
		this.specialization = specialization;
		this.avaliability = avaliability;
		this.approval = approval;
		this.hospitals = hospitals;
	}

	public DoctorDetails(String name, String pnumber, String specialization, boolean avaliability, boolean approval,
			Set<Hospital> hospitals) {
		super();
		this.name = name;
		this.pnumber = pnumber;
		this.specialization = specialization;
		this.avaliability = avaliability;
		this.approval = approval;
		this.hospitals = hospitals;
	}

//	@OneToOne(targetEntity=user_details.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="doctordetails")
//	private user_details userdetails;

}
