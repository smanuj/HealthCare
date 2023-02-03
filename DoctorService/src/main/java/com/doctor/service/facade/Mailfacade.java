package com.doctor.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.NurseDetails;
import com.doctor.service.repository.NurseDetailsRepository;
import com.doctor.service.service.NurseDetailsService;

@Component
public class Mailfacade {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private NurseDetailsService nurseDetailsService;
	
	private static final String mail_URL = "http://localhost:8008/api/s1";
	
	public void sendComments(Comments comments) {
		restTemplate.postForEntity(mail_URL+"/sendComments", comments, Comments.class);
		System.out.println(comments.getPatients().getNurseId());
		System.out.println("test mail facade 1");
//		String str="Comments sent Successfully";
//		return str;
	}
}
