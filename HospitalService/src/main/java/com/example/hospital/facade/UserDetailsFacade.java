package com.example.hospital.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.NurseDetails;
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

public String doctorApproval(int id) {
	return restTemplate.postForObject(Login_URL+"/doctorApproval/"+id,null,null,id);
}
	


public List<NurseDetails> getNurses(){
	return Arrays.asList(restTemplate.getForObject(Login_URL+"/nurseApproval",NurseDetails[].class ));
}

public DoctorDetails getdoctorbyid(int id) {
	return restTemplate.getForObject(Login_URL+"/doctor/"+id, DoctorDetails.class);
}

public ResponseEntity<DoctorDetails> savedoctor(DoctorDetails doctordetails) {
	return restTemplate.postForEntity(Login_URL+"/api/doctor", doctordetails, DoctorDetails.class);
	
}

public String nurseApproval(int id) {
	return restTemplate.postForObject(Login_URL+"/nurseApproval/"+id,null,null,id);
}

public NurseDetails getNurseById(int id) {
	return restTemplate.getForObject(Login_URL+"/nurse/"+id, NurseDetails.class);
}

public ResponseEntity<NurseDetails> saveNurse(NurseDetails nurseDetails) {
	return restTemplate.postForEntity(Login_URL+"/api/nurse", nurseDetails, NurseDetails.class);
	
}

public void doctordisapprove(int id) {
	/*return restTemplate.postForObject(Login_URL+"/doctorDisapproval/"+id,null,null,id);*/
	
	restTemplate.delete(Login_URL+"/doctorDisapproval/"+id, id);
}

public void nursedisapprove(int id) {
	restTemplate.delete(Login_URL+"/nurseDisapproval/"+id, id);
}
	
}
