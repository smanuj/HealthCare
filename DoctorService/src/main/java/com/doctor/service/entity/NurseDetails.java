package com.doctor.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class NurseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int nurseId;
	private String name;
	private String pnumber;
	private boolean avaliability;
	private boolean approval;
//	@OneToOne(targetEntity = UserDetails.class)
//	@JoinColumn(name = "nurseId", referencedColumnName = "nurseId")
//	private UserDetails userdetails;

	

	public int getNurseId() {
		return nurseId;
	}



	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
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



	
	
	



	public NurseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public NurseDetails(int nurseId, String name, String pnumber, boolean avaliability, boolean approval,
			UserDetails userdetails) {
		super();
		this.nurseId = nurseId;
		this.name = name;
		this.pnumber = pnumber;
		this.avaliability = avaliability;
		this.approval = approval;
	}
	
	



	public NurseDetails(String name, String pnumber, boolean avaliability, boolean approval, UserDetails userdetails) {
		super();
		this.name = name;
		this.pnumber = pnumber;
		this.avaliability = avaliability;
		this.approval = approval;
	}
	 
	


	public NurseDetails(String name, String pnumber, boolean avaliability, boolean approval) {
		super();
		this.name = name;
		this.pnumber = pnumber;
		this.avaliability = avaliability;
		this.approval = approval;
	}



	@Override
	public String toString() {
		return "NurseDetails [nurseId=" + nurseId + ", name=" + name + ", pnumber=" + pnumber + ", avaliability="
				+ avaliability + ", approval=" + approval + "]";
	}
	
	

}
