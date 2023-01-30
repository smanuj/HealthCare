package com.mail.microservice.services;

import java.util.List;

import com.mail.microservice.entity.UserDetails;

public interface ForgotPass {

	boolean checkMailId(String email);

	String getRandomNumberString();

	boolean generateOtp(UserDetails user);

	boolean checkpassword(int id, String password);

	void changepassword(int id, String password);

	int getidbyemail(String email);

	UserDetails getuserdetailsbyid(int id);

	List<UserDetails> getalluser();

}