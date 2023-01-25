package com.mail.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.microservice.entity.MailTable;
import com.mail.microservice.entity.UserDetails;
import com.mail.microservice.facade.Userfacade;
import com.mail.microservice.repo.MailRepo;

@Service
public class MailDataImpl implements MailData {

	@Autowired
	MailRepo mailRepo;

	@Autowired
	Userfacade userfacade;

	@Override
	public void saveMail(String email, String subject, String body, boolean b) {

		UserDetails usr = userfacade.getbyemail(email);
		MailTable mt = new MailTable(usr, subject, body, b);
		mailRepo.save(mt);
	}

	@Override
	public List<MailTable> getAllUnsentMails() {
		return mailRepo.findAllBySentFalse();
	}
}
