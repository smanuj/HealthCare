package com.mail.microservice.services;

public interface MailData {

	void saveMail(String email, String subject, String body, boolean b);


}