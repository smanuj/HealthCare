package com.mail.microservice.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String comments;
	@OneToOne(targetEntity = DoctorDetails.class)
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private DoctorDetails doctorId;
	@OneToOne(targetEntity = NurseDetails.class)
	@JoinColumn(name = "nurseId", referencedColumnName = "nurseId")
	private NurseDetails nurseId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public DoctorDetails getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(DoctorDetails doctorId) {
		this.doctorId = doctorId;
	}

	public NurseDetails getNurseId() {
		return nurseId;
	}

	public void setNurseId(NurseDetails nurseId) {
		this.nurseId = nurseId;
	}

	public Comments(int commentId, String comments, DoctorDetails doctorId, NurseDetails nurseId) {
		super();
		this.commentId = commentId;
		this.comments = comments;
		this.doctorId = doctorId;
		this.nurseId = nurseId;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(String comments, DoctorDetails doctorId, NurseDetails nurseId) {
		super();
		this.comments = comments;
		this.doctorId = doctorId;
		this.nurseId = nurseId;
	}

//	public static Comments getCommentsById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
