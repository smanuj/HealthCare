package com.mail.microservice.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.facade.Userfacade;

@Service
public class ForgotPassImpl implements ForgotPass {


	
	@Autowired
	MailMessage mailMessage;
	
	@Autowired
	private Userfacade userfacade;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean checkMailId(String email) {
		List<UserDetails> allUsers =userfacade.getuser();
		System.out.println(allUsers);
		for(UserDetails user1:allUsers) {
//			String s1= "{\"email\":\""+user1.getEmail()+"\"}";
//			System.out.println(user1.getEmail());
//			System.out.println(email);
			System.out.println("test1 "+user1.getEmail());
			if(email.equals(user1.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public  String getRandomNumberString() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		return String.format("%06d", number);
	}
	
	@Override
	public boolean generateOtp(UserDetails user) {
		System.out.println("test2 "+user.getEmail());
		UserDetails usr = userfacade.getbyemail(user.getEmail());
		System.out.println("usr: "+usr);
		String otp1=getRandomNumberString();
		mailMessage.sendOTP(usr.getEmail(), otp1);
		String Otp = bCryptPasswordEncoder.encode(otp1);
		usr.setPassword(Otp);
		System.out.println("usr after otp: "+usr);
		ResponseEntity<UserDetails> user1= userfacade.saveUser(usr);
		return true;
		
	}
	
	@Override
	public boolean checkpassword(int id,String password) {
		return userfacade.checkpassword(id, password);
	}
	
	@Override
	public void changepassword(int id,String password) {
		UserDetails usr= userfacade.findById(id);
		usr.setPassword(password);
		userfacade.saveUser(usr);
	}
	
	
	
	
	
//	bCryptPasswordEncoder.matches(password, u.getPassword())
	
	
//	public String savedoctor(user_details user) {
//		int flag=0;
//		List<user_details> users= userrepo.findAll();
//		for(user_details user1:users) {
//			if(user1.getEmail().equals(user.getEmail())) {
//				flag=1;
//			}
//		}
//		if(flag==1) {
//			return "not";
//		}
//		  Doctor_details d = user.getDoctordetails();
//		  d.setApproval(false);
//		  d.setAvaliability(true);
//		  Doctor_details d1 = doctorservice.savedoctor(d);
//		  user_details u = new user_details(user.getEmail(), user.getPassword(), d1);
//		  userrepo.save(u);
//		  return "saved";
//	}
}
