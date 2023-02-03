package com.patient.microservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.patient.microservice.entity.NurseDetails;

@Component
public class LoginFacade {

	
	@Autowired
	private RestTemplate restTemplate;

	private static final String user_URL = "http://localhost:8002/api/login/";
	
	public NurseDetails genursebyid(int id) {
	 return restTemplate.getForObject(user_URL + "/nurse/" +id, NurseDetails.class);
	}
}
