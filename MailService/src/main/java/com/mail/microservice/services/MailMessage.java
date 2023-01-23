package com.mail.microservice.services;

import com.mail.microservice.entity.PatientDetails;
import com.mail.microservice.entity.UserDetails;

public interface MailMessage {

	void sendAlert(int id, PatientDetails pd);

	void sendOTP(String email, String pass);

	void registeredSuccessfully(UserDetails user);

	void registerationFailure(UserDetails user);

	void successfulPasswordChange(UserDetails user);

	void notifyRegisteration(UserDetails user);

}