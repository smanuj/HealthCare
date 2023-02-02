package com.doctor.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.doctor.service.entity.PatientDetails;

@Component
public class Patientfacade {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String mail_URL = "http://localhost:8009/api/patients";
	
	public PatientDetails getPatientDetailsById(int id) {
		return restTemplate.getForObject(mail_URL+"/patientDetails/"+id, PatientDetails.class);
		
	}

}
