package com.mail.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.microservice.entity.PatientDetails;
import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.services.ForgotPass;
import com.mail.microservice.services.MailMessage;
import com.mail.microservice.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/s1/")
public class MailController {

	@Autowired
	MailMessage mailMessage;

	@Autowired
	ForgotPass forgotPass;

	@Autowired
	UserService userService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/reset/forgotPass")
	public String forgotPass(@RequestBody UserDetails user) {
		boolean b = forgotPass.checkMailId(user.getEmail());
		if (b == true) {
			forgotPass.generateOtp(user);
			return "sent";
		}
		return "fail";
	}

	@PostMapping("/reset/newPass/{id}")
	public String newPass(@PathVariable("id") int id, @RequestBody UserDetails user) {
		// retrieving OTP in email field as a string
		String otp = user.getEmail();
		boolean b = userService.checkPassword(id, otp);
		if (b == true) {
			String password = bCryptPasswordEncoder.encode(user.getPassword());
			userService.changePassword(id, password);
			return "changed";
		}
		return "fail";
	}
	
	@PostMapping("/patientDetails/sendMail/{id}")
	public void alertDoctor(@PathVariable("id") int id, @RequestBody PatientDetails pd) {
		mailMessage.sendAlert(id, pd);
	}
}
