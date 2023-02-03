package com.patient.microservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.patient.microservice.entity.PatientDetails;

@Component
public class MailFacade {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String user_URL = "http://localhost:8008/api/s1/";
	
	public String alertDoctor(int id, PatientDetails patientDetails) {
		restTemplate.postForObject(user_URL +"/patientDetails/sendMail/" + id,null,null,patientDetails);
		return "alert sent";
	}
	
}
//@PostMapping("/patientDetails/sendMail/{id}")
//public void alertDoctor(@PathVariable("id") int id, @RequestBody PatientDetails pd) {
//	mailMessage.sendAlert(id, pd);
//}
//
