package com.login.service.service;

import java.util.List;
import java.util.Optional;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;

public interface DoctorService {
	
	DoctorDetails savedoctor(DoctorDetails doctor);
	
	List<DoctorDetails>  getByapprovefalse();
	
	
	void deletedoctor(int id);
	
	DoctorDetails approvingDoctor(int id);
	
	List<Hospital> gethospitallist();
	
	Optional<DoctorDetails> doctorgetdoctorbyid(int id);
	
	

}