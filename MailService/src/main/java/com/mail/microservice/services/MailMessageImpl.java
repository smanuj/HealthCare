package com.mail.microservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mail.microservice.entity.UserDetails;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MailMessageImpl implements MailMessage{

	private static final Logger logger = LoggerFactory.getLogger(MailMessageImpl.class);

//	@Autowired
//	EmailService emailService;

	@Autowired
	SendMail sendMail;
	
	@Autowired
	MailData mailData;

	@Override
	public void sendAlert(String email, String name) {
//		logger.debug("Sending alert to " + name + " associated with mail " + email);
		String subject = "Alert!! " + name;
		String body = "Hello delivery partner, Please pull over whenever it is safe to do so and examine the delivery contents and the truck as the temperature seems to be highly varying as compared to the ideal temp. -admin";
		sendMail.sendMail(email, subject, body);
	}

	@Override
	public void registeredSuccessfully(UserDetails user) {
		logger.debug(
				"Successfully registered User with email: " + user.getEmail());
		String subject = "Congratulations! ";
//		String role = 
		String body = "Hello, You have successfully registered as " + //role
				 " at Health Care App, you can now log in to your account through the website using your registered email id and password. Thank you for choosing us :) -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

	@Override
	public void registerationFailure(String email, String role, String name) {
		logger.debug("Registering User with email: " + email + " under role: " + role + " by name: " + name
				+ " has Failed! ");
		String subject = "Dart Express Logistics " + name;
		String body = "Hello, We regret to inform you that your regristration request was not successful for " + role
				+ " . This might have occured due to various reasons. Please contact us for more info. Thank you for understanding, you can try registering again if you think there was a mistake  -admin";
		sendMail.sendMail(email, subject, body);
	}

	@Override
	public void sendOTP(String email, String pass) {
		logger.debug("Sending OTP to " + email);
		String subject = "OTP to reset password ";
		String body = "Hello, Please use this OTP to reset your account password: " + pass
				+ " DO NOT SHARE THIS OTP WITH ANYONE!!. -admin";
		try {
			sendMail.sendMail(email, subject, body);
			mailData.saveMail(email,subject,body,true);
		} catch (Exception e) {
			mailData.saveMail(email,subject,body,false);
			e.printStackTrace();
		}
	}

	@Override
	public void successfulPasswordChange(String email, String role, String name) {
		logger.debug("Password has been successfully changed for " + email + " registered under role: " + role
				+ " by name: " + name);
		String subject = "Password Changed Successfully " + name;
		String body = "Congratulations, your password has been changed successfully for the " + role
				+ " login. You can now log in to your account through the website using your registered email id and new password. -admin";
		sendMail.sendMail(email, subject, body);
	}

	@Override
	public void notifyRegisteration(String email, String role, String name) {
		logger.debug("Registration Request Recieved from " + email + " for role " + role + " by name " + name);
		String subject = "Registeration form recieved from " + name;
		String body = "Hello, Your registeration form is received for the role: " + role
				+ " You will be notified regarding the approval soon. -admin";
		sendMail.sendMail(email, subject, body);
	}

}