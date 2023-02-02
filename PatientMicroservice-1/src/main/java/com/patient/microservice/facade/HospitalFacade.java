package com.patient.microservice.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.patient.microservice.entity.Hospital;




@Component

public class HospitalFacade {
	@Autowired
	
	RestTemplate restTemplate;
	private static final String Login_URL="http://localhost:8003/api/v1";
	
	public List<Hospital> findByPincode(@PathVariable String pincode) {
	 return Arrays.asList(restTemplate.getForObject(Login_URL +"/hospitals/pincode/" + pincode,Hospital[].class));
	}

	
	
	
	

}

//public ResponseEntity<NurseDetails> saveNurse(NurseDetails nurseDetails) {
//	return restTemplate.postForEntity(Login_URL+"/api/nurse", nurseDetails, NurseDetails.class);
//
//	
//}
