package com.mail.microservice.services;

import com.mail.microservice.entity.UserDetails;

public interface MailMessage {

	void sendAlert(String email, String name);

	void registerationFailure(String email, String role, String name);

	void sendOTP(String email, String pass);

	void successfulPasswordChange(String email, String role, String name);

	void notifyRegisteration(String email, String role, String name);

	void registeredSuccessfully(UserDetails user);

}