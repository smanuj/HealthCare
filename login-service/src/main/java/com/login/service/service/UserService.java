package com.login.service.service;

import java.util.List;

import com.login.service.entity.UserDetails;

public interface UserService {

	UserDetails getbyemail(String email);

	UserDetails saveuser(UserDetails user);
	
	String savedoctor(UserDetails user) throws Exception;
	
	String savenurse(UserDetails user);
	
	String  loginuser(UserDetails user) throws Exception;
	
	List<UserDetails> getalluser();
	
	void deletuser(int id);

}