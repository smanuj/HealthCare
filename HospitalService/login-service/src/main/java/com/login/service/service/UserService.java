package com.login.service.service;

import java.util.List;

import com.login.service.entity.user_details;

public interface UserService {

	user_details getbyemail(String email);

	user_details saveuser(user_details user);
	
	String savedoctor(user_details user);
	
	String savenurse(user_details user);
	
	String  loginuser(user_details user);
	
	List<user_details> getalluser();

}