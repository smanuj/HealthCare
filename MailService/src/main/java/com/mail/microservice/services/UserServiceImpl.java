package com.mail.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.repo.UserRepo;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepo userRepo;
	
//	public String checkRole(UserDetails user) {
//		
//	}
}
