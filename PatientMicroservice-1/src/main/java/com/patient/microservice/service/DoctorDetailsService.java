package com.patient.microservice.service;

import java.util.List;

import com.patient.microservice.entity.DoctorDetails;

public interface DoctorDetailsService {


	List<DoctorDetails> getDoctors(String specialization);
	

}
