package com.mail.microservice.services;

import com.mail.microservice.entity.UserDetails;

public interface ForgotPass {

	boolean checkMailId(String email);

	String getRandomNumberString();

	boolean generateOtp(UserDetails user);

}