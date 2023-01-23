package com.login.service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Nurse_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pnumber;
	private boolean avaliability;
	private boolean approval;
	
	
	@OneToOne(targetEntity=user_details.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="nursedetails")
	private user_details userdetails;
	
	public Nurse_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nurse_details(String name, String pnumber) {
		super();
		this.name = name;
		this.pnumber = pnumber;
	}
	public Nurse_details(int id, String name, String pnumber) {
		super();
		this.id = id;
		this.name = name;
		this.pnumber = pnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Nurse_details [id=" + id + ", name=" + name + ", pnumber=" + pnumber + ", avaliability=" + avaliability
				+ ", approval=" + approval + "]";
	}
	
	

}
