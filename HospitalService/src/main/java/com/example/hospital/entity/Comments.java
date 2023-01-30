package com.example.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int commentId;
	private String comments;
	@JsonIgnoreProperties("comments")
	@ManyToOne()
	@JoinColumn(name = "patient_id")
	private PatientDetails patients;
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
	public PatientDetails getPatients() {
		return patients;
	}
	public void setPatients(PatientDetails patients) {
		this.patients = patients;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int commentId, String comments, PatientDetails patients) {
		super();
		this.commentId = commentId;
		this.comments = comments;
		this.patients = patients;
	}
	public Comments(String comments, PatientDetails patients) {
		super();
		this.comments = comments;
		this.patients = patients;
	}
	
	
	
}
