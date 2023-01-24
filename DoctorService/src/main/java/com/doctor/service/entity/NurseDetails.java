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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nurseId;
	private String name;
	private String pnumber;
	private boolean avaliability;
	private boolean approval;
	@OneToOne(targetEntity = UserDetails.class)
	@JoinColumn(name = "nurseId", referencedColumnName = "nurseId")
	private UserDetails userdetails;

	public NurseDetails() {
		super();
	}

	public NurseDetails(String name, String pnumber) {
		super();
		this.name = name;
		this.pnumber = pnumber;
	}

	public NurseDetails(int id, String name, String pnumber) {
		super();
		this.nurseId = id;
		this.name = name;
		this.pnumber = pnumber;
	}

	public int getId() {
		return nurseId;
	}

	public void setId(int id) {
		this.nurseId = id;
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

}
