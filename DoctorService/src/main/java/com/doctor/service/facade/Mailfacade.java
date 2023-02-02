package com.doctor.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.doctor.service.entity.Comments;

@Component
public class Mailfacade {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String mail_URL = "http://localhost:8008/api/s1";
	
	public String sendComments(Comments comments) {
		restTemplate.postForObject(mail_URL+"/sendComments", comments, Comments.class);
		String str="Comments sended Successfully";
		return str;
	}
}
