package com.mail.microservice.services;

import org.springframework.web.bind.annotation.RequestMapping;

public interface SendMail {

	void sendMail(String email, String subject, String body);

}