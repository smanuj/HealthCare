package com.login.service.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class DoctorDetails implements Serializable {
	
	@Id
	@Column(name = "doctorId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int doctorId;
	private String name;
	private String pnumber;
	private String specialization;
	private boolean avaliability;
	private boolean approval;
//	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	@JoinTable(name = "doctorHospitalMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "hospitalId"))
//	private Set<Hospital> hospitals;
	
	@OneToOne(targetEntity = Hospital.class)
	@JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId")
	private Hospital hospitalId;

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



	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DoctorDetails(int doctorId, String name, String pnumber, String specialization, boolean avaliability,
			boolean approval) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.pnumber = pnumber;
		this.specialization = specialization;
		this.avaliability = avaliability;
		this.approval = approval;
		
	}

	public DoctorDetails(String name, String pnumber, String specialization, boolean avaliability, boolean approval
			) {
		super();
		this.name = name;
		this.pnumber = pnumber;
		this.specialization = specialization;
		this.avaliability = avaliability;
		this.approval = approval;
		
	}

	public Hospital getHospital() {
		return hospitalId;
	}

	public void setHospital(Hospital hospital) {
		this.hospitalId = hospital;
	}

	@Override
	public String toString() {
		return "DoctorDetails [doctorId=" + doctorId + ", name=" + name + ", pnumber=" + pnumber + ", specialization="
				+ specialization + ", avaliability=" + avaliability + ", approval=" + approval + ", hospital="
				+ hospitalId + "]";
	}

	
	
	
	
	
	
	

}
