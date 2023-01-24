package com.mail.microservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mail.microservice.entity.PatientDetails;
import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MailMessageImpl implements MailMessage {

	private static final Logger logger = LoggerFactory.getLogger(MailMessageImpl.class);

//	@Autowired
//	EmailService emailService;

	@Autowired
	SendMail sendMail;

	@Autowired
	MailData mailData;

	@Autowired
	UserService userService;

	@Autowired
	UserRepo userRepo;

	@Override
	public void sendAlert(int id, PatientDetails pd) {
		UserDetails user = userRepo.findById(id).get();
		String subject = "Alert!! ";
		String condition = pd.getDisease();
		String doctor = pd.getDoctorId().getName();
		String pr = pd.getPulse_rate();
		String oxy = pd.getOxygenlevel();
		String temp = pd.getTemperature();
		String body = "Hello " + doctor
				+ ", A patient with immediate need of your attention is headed your way with the medical condition: "
				+ condition + "\n Current pulse rate is : " + pr + "\n Oxygen level: " + oxy + "\n Temperature: " + temp
				+ " Please prepare and update the nurse on-board accordingly -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

	@Override
	public void registeredSuccessfully(UserDetails user) {
		logger.debug("Successfully registered User with email: " + user.getEmail());
		String subject = "Congratulations! ";
		String role = userService.getRole(user);
		String body = "Hello, You have successfully registered as " + role
				+ " at Health Care App, you can now log in to your account through the website using your registered email id and password. Thank you for choosing us :) -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

	@Override
	public void registerationFailure(UserDetails user) {
		logger.debug("Registering User with email: " + user.getEmail() + " under role: " + userService.getRole(user)
				+ " has Failed! ");
		String subject = "Dart Express Logistics ";
		String body = "Hello, We regret to inform you that your regristration request was not successful for "
				+ userService.getRole(user)
				+ " . This might have occured due to various reasons. Please contact us for more info. Thank you for understanding, you can try registering again if you think there was a mistake  -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

	@Override
	public void sendOTP(String email, String pass) {
		logger.debug("Sending OTP to " + email);
		String subject = "OTP to reset password ";
		String body = "Hello, Please use this OTP to reset your account password: " + pass
				+ " DO NOT SHARE THIS OTP WITH ANYONE!!. -admin";
		try {
			sendMail.sendMail(email, subject, body);
			mailData.saveMail(email, subject, body, true);
		} catch (Exception e) {
			mailData.saveMail(email, subject, body, false);
			e.printStackTrace();
		}
	}

	@Override
	public void successfulPasswordChange(UserDetails user) {
		logger.debug("Password has been successfully changed for " + user.getEmail() + " registered under role: "
				+ userService.getRole(user));
		String subject = "Password Changed Successfully ";
		String body = "Congratulations, your password has been changed successfully. You can now log in to your account through the website using your registered email id and new password. -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

	@Override
	public void notifyRegisteration(UserDetails user) {
		logger.debug(
				"Registration Request Recieved from " + user.getEmail() + " for role " + userService.getRole(user));
		String subject = "Registeration form recieved";
		String body = "Hello, Your registeration form is received for the role: " + userService.getRole(user)
				+ " You will be notified regarding the approval soon. -admin";
		sendMail.sendMail(user.getEmail(), subject, body);
	}

}