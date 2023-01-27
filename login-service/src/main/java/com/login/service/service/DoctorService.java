package com.login.service.service;

import java.util.List;
import java.util.Optional;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;

public interface DoctorService {
	
	DoctorDetails saveDoctor(DoctorDetails doctor);
	
	List<DoctorDetails>  getByapprovefalse();
	
	
	void deleteDoctor(int id);
	
	DoctorDetails approvingDoctor(int id);
	
	List<Hospital> getHospitalList();
	
	Optional<DoctorDetails> doctorgetdoctorbyid(int id);
	
	

}