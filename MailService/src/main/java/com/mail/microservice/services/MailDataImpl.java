package com.mail.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.MailTable;
import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.repo.MailRepo;
import com.mail.microservice.repo.UserRepo;

@Service
public class MailDataImpl implements MailData {
	
	@Autowired
	MailRepo mailRepo;
	
	@Autowired
	UserRepo userRepo;

	@Override
	public void saveMail(String email, String subject, String body, boolean b) {

		UserDetails usr = userRepo.findByEmail(email);
		MailTable mt = new MailTable(usr, subject, body, b);
		mailRepo.save(mt);
	}

	
}
