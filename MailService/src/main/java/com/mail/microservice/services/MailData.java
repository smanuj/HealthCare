package com.mail.microservice.services;

import java.util.List;

import com.mail.microservice.entity.MailTable;

public interface MailData {

	void saveMail(String email, String subject, String body, boolean b);

	List<MailTable> getAllUnsentMails();


}