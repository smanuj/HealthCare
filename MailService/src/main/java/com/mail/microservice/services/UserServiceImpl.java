package com.mail.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String getRole(UserDetails user) {
		if (user.getDoctordetails() != null) {
			return "doctor";
		} else if (user.getNursedetails() != null) {
			return "nurse";
		}
		return "admin";
	}

	@Override
	public boolean checkPassword(int id, String password) {
		UserDetails u = userRepo.findById(id).get();
		if (bCryptPasswordEncoder.matches(password, u.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		UserDetails u = userRepo.findById(id).get();
		u.setPassword(password);
		userRepo.save(u);

	}
}
