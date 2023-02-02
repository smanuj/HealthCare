package com.mail.microservice.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mail.microservice.entity.DoctorDetails;
import com.mail.microservice.entity.NurseDetails;
import com.mail.microservice.entity.UserDetails;

@Component
public class Userfacade {

	@Autowired
	private RestTemplate restTemplate;

	private static final String user_URL = "http://localhost:8002/api/login/";

	public List<UserDetails> getuser() {
		return Arrays.asList(restTemplate.getForObject(user_URL + "/users", UserDetails[].class));
	}

	public UserDetails getbyemail(String email) {
		return restTemplate.getForObject(user_URL + "/" + email, UserDetails.class);
	}

	public ResponseEntity<UserDetails> saveUser(UserDetails userDetails) {
		System.out.println("facade usr: "+userDetails);
		return restTemplate.postForEntity(user_URL + "/saveuser", userDetails,UserDetails.class);
	}

	public UserDetails findById(int id) {
		return restTemplate.getForObject(user_URL + "/user/" + id, UserDetails.class);
	}

	public boolean checkpassword(int id, String password) {
		Boolean response = restTemplate.getForObject(user_URL+"/"+id+"/"+password, Boolean.class);
		System.out.println(response);
		return response;

		
	}

	public void changepassword(int id, String password) {
		restTemplate.postForObject(user_URL + "/" + id + "/" + password, null, null,id,password);
	}

	public String getrole(UserDetails userDetails) {
		String s1= restTemplate.getForObject(user_URL + "/getrole/"+userDetails,String.class);
		System.out.println(s1);
		return s1;
	}
	
	public UserDetails findByDoctorDetails(DoctorDetails d) {
		return restTemplate.postForObject(user_URL + "/doctorbyuserdetails",d, UserDetails.class);
	}
	
	public UserDetails findByNurseDetails(NurseDetails n) {
		return restTemplate.postForObject(user_URL + "/userdetailsbynurse",n, UserDetails.class);
	}
	

}
