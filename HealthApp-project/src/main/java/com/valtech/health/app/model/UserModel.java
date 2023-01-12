package com.valtech.health.app.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class UserModel {

	private int id;

	@NotBlank(message = "Name cannot be empty!!")
	private String name;
	private String pnumber;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String confirmpassword;
	private String role;
	@Column(nullable = true)
	private int otp;

	public UserModel() {
		super();
	}

	
	public UserModel(int id,String name, String pnumber, String email,
			String username, String password, String confirmpassword, String role, int otp) {
		super();
		this.id = id;
		this.name = name;
		this.pnumber = pnumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.role = role;
		this.otp = otp;
	}

	public UserModel(String name, String pnumber, String email,
			String username, String password, String confirmpassword, String role, int otp) {
		super();
		this.name = name;
		this.pnumber = pnumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.role = role;
		this.otp = otp;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", number=" + pnumber + ", email=" + email + ", username="
				+ username + ", password=" + password  + ", role=" + role
				+ ", otp=" + otp + "]";
	}
}
