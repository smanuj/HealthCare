package com.mail.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.microservice.entity.Comments;
import com.mail.microservice.entity.PatientDetails;
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

	

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/reset/forgotPass")
	public String forgotPass(@RequestBody UserDetails user) {
		System.out.println(user.getEmail());
		boolean b = forgotPass.checkMailId(user.getEmail());
		System.out.println(b);
		if (b == true) {
		Boolean forgot =	forgotPass.generateOtp(user);
		System.out.println(forgot);
		String s1="sent";
			return s1;
		}
		String s2="fail";
		return s2;
	}

	@PostMapping("/reset/newPass/{id}")
	public String newPass(@PathVariable("id") int id, @RequestBody UserDetails user) {
		
		// retrieving OTP in email field as a string
		String otp = user.getEmail();
		boolean b = forgotPass.checkpassword(id, otp);
		if (b == true) {
			String password = bCryptPasswordEncoder.encode(user.getPassword());
			forgotPass.changepassword(id, password);
			return "changed";
		}
		return "fail";
	}
	
	@PostMapping("/patientDetails/sendMail/{id}")
	public void alertDoctor(@PathVariable("id") int id, @RequestBody PatientDetails pd) {
		mailMessage.sendAlert(id, pd);
	}
	
	@GetMapping("/getid/{email}")
	public int getidbyemail(@PathVariable("email") String email) {
		return forgotPass.getidbyemail(email);
	}
	
	@PostMapping("/notifyregistration")
	public void notifyregistration(@RequestBody UserDetails user) {
		System.out.println("sending mail");
		mailMessage.notifyRegisteration(user);
	}
	
	@GetMapping("/registersuccessfulfordoctor/{id}")
	public void registrationsuccesull(@PathVariable("id") int id) {
		
		List<UserDetails> user1= forgotPass.getalluser();
		UserDetails user = null;
		for (UserDetails u : user1) {
			if (u.getDoctordetails() != null && u.getDoctordetails().getDoctorId() == id) {

			 user = u;
			}
		}
		
		UserDetails user2 = forgotPass.getuserdetailsbyid(user.getId());
		mailMessage.registeredSuccessfully(user2);
		
	}
	
	@GetMapping("/registersuccessfulfornurse/{id}")
	public void registrationsuccesullnurse(@PathVariable("id") int id) {
		
		List<UserDetails> user1= forgotPass.getalluser();
		UserDetails user = null;
		for (UserDetails u : user1) {
			if (u.getNursedetails() != null && u.getNursedetails().getNurseId() == id) {

			 user = u;
			}
		}
		
		UserDetails user2 = forgotPass.getuserdetailsbyid(user.getId());
		mailMessage.registeredSuccessfully(user2);
		
	}
	
	@GetMapping("/registerfailurefordoctor/{id}")
	public void registrationfailure(@PathVariable("id") int id) {
		
		List<UserDetails> user1= forgotPass.getalluser();
		UserDetails user = null;
		for (UserDetails u : user1) {
			if (u.getDoctordetails() != null && u.getDoctordetails().getDoctorId() == id) {

			 user = u;
			}
		}
		
		UserDetails user2 = forgotPass.getuserdetailsbyid(user.getId());
		mailMessage.registerationFailure(user2);
		
	}
	
	@GetMapping("/registerfailurefornurse/{id}")
	public void registrationfailurenurse(@PathVariable("id") int id) {
		
		List<UserDetails> user1= forgotPass.getalluser();
		UserDetails user = null;
		for (UserDetails u : user1) {
			if (u.getNursedetails() != null && u.getNursedetails().getNurseId() == id) {

			 user = u;
			}
		}
		
		UserDetails user2 = forgotPass.getuserdetailsbyid(user.getId());
		mailMessage.registerationFailure(user2);
		
	}
	
	@GetMapping("/{id}")
	public UserDetails getbyid(@PathVariable("id") int id) {
		return forgotPass.getuserdetailsbyid(id);
	}
	
	@PostMapping("/sendComments")
	public void sendComments(Comments comments) {
		mailMessage.sendComments(comments);
	}
}
