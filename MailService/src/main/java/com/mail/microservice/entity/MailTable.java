package com.mail.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MailTable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mailId;
	@OneToOne(targetEntity = UserDetails.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private UserDetails userId;
	private String subject;
	private String body;
	private boolean sent;

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public MailTable() {
		super();
	}

	public MailTable(int mailId, UserDetails userId, String subject, String body, boolean sent) {
		super();
		this.mailId = mailId;
		this.userId = userId;
		this.subject = subject;
		this.body = body;
		this.sent = sent;
	}

	public MailTable(UserDetails userId, String subject, String body, boolean sent) {
		super();
		this.userId = userId;
		this.subject = subject;
		this.body = body;
		this.sent = sent;
	}

	@Override
	public String toString() {
		return "MailTable [mailId=" + mailId + ", userId=" + userId + ", subject=" + subject + ", body=" + body
				+ ", sent=" + sent + "]";
	}

}
