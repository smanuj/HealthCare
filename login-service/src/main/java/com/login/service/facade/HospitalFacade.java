package com.login.service.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.login.service.entity.Hospital;

@Component
public class HospitalFacade {
	
	@Autowired
	private RestTemplate restTemplate;

	private static final String Hospital_URL="http://localhost:8081/api/v1";
	
	
	public List<Hospital> getallhospital(){
		return Arrays.asList(restTemplate.getForObject(Hospital_URL+"/hospitals",Hospital[].class ));
	}
	
	public Hospital  gethospitalbyid(int id) {
		return restTemplate.getForObject(Hospital_URL+"/hospitals/"+id,Hospital.class );
	}

}
