package com.valtech.health.app.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotBlank(message = "Name cannot be empty!!")
	private String name;
	private String pnumber;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String role;
	@Column(nullable = true)
	private int otp;
	@OneToMany(targetEntity = PatientDetails.class, cascade = { CascadeType.MERGE,
            CascadeType.PERSIST }, fetch = FetchType.EAGER, mappedBy = "users")
    private Set<PatientDetails> patientDetails;
  
	public User() {
		super();
	}

	public User(String name, String pnumber, String email, String username, String password, String role, int otp) {
		super();

		this.name = name;
		this.pnumber = pnumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.otp = otp;
	}

	public User(int id, String name, String pnumber, String email, String username, String password, String role,
			int otp) {
		super();
		this.id = id;
		this.name = name;
		this.pnumber = pnumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.otp = otp;
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

	public Set<PatientDetails> getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(Set<PatientDetails> patientDetails) {
		this.patientDetails = patientDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pnumber=" + pnumber + ", email=" + email + ", username="
				+ username + ", password=" + password + ", role=" + role + "]";
	}

}
