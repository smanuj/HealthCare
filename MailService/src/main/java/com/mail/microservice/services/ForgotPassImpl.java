package com.mail.microservice.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.repo.UserRepo;

@Service
public class ForgotPassImpl implements ForgotPass {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	MailMessage mailMessage;

	@Override
	public boolean checkMailId(String email) {
		List<UserDetails> allUsers = userRepo.findAll();
		for(UserDetails user1:allUsers) {
//			String s1= "{\"email\":\""+user1.getEmail()+"\"}";
			System.out.println(user1.getEmail());
			System.out.println(email);
			if(user1.getEmail().equals(email)) {
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
		
		UserDetails usr = userRepo.findByEmail(user.getEmail());
		String Otp = getRandomNumberString();
		mailMessage.sendOTP(usr.getEmail(), Otp);
		usr.setPassword(Otp);
		userRepo.save(usr);
		return true;
		
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
