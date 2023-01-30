package com.login.service.service;

import java.util.List;
import java.util.Optional;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.UserDetails;

public interface UserService {

	UserDetails getByEmail(String email);

	UserDetails saveUser(UserDetails user);
	
	String saveDoctor(UserDetails user) throws Exception;
	
	String saveNurse(UserDetails user) throws Exception;
	
	String  loginUser(UserDetails user) throws Exception;
	
	List<UserDetails> getalluser();
	
	void deletUser(int id);
	
	Hospital getById(int id);
	
	
	
	String getRole(UserDetails user);
	
	boolean checkPassword(int id, String password);
	
	void changePassword(int id, String password);

	UserDetails findById(int id);

	int doctorlogin(String email);

	int nurselogin(String email);

	UserDetails getbydoctordetails(DoctorDetails doctor);

}