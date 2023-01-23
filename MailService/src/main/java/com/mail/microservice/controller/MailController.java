package com.mail.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.services.ForgotPass;
import com.mail.microservice.services.MailMessage;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/s1/")
public class MailController {

	@Autowired
	MailMessage mailMessage;

	@Autowired
	ForgotPass forgotPass;

	@PostMapping("/reset/forgotPass")
	public String forgotPass(@RequestBody UserDetails user) {
		boolean b = forgotPass.checkMailId(user.getEmail());
		if (b == true) {
			forgotPass.generateOtp(user);
			return "sent";
		}
		return "fail";
	}
	
	@PostMapping("/reset/newPass")
	public String newPass(@RequestBody UserDetails user) {
		boolean b = forgotPass.checkMailId(user.getEmail());
		if (b == true) {
			forgotPass.generateOtp(user);
			return "sent";
		}
		return "fail";
	}
}
