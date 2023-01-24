package com.example.hospital.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.UserDetails;

@Component
public class UserDetailsFacade {
	
@Autowired
private RestTemplate restTemplate;

private static final String Login_URL="http://localhost:8080/";

public List<UserDetails> getuser(){
	return Arrays.asList(restTemplate.getForObject(Login_URL+"/api/users",UserDetails[].class ));
}


public List<DoctorDetails> getdoctors(){
	return Arrays.asList(restTemplate.getForObject(Login_URL+"/doctor",DoctorDetails[].class ));
}

}
