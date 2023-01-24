package com.doctor.service.service;

import java.util.List;

import com.doctor.service.entity.DoctorDetails;

public interface DoctorDetailsService {


	List<DoctorDetails> getAllDoctorsBySpecialization(String specialization);
	
	DoctorDetails getDoctorsById(int id);
	
	DoctorDetails saveDoctor(DoctorDetails doctorDetails);
	

}
