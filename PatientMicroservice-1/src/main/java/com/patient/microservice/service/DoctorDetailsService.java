package com.patient.microservice.service;

import java.util.List;


import com.patient.microservice.entity.DoctorDetails;

public interface DoctorDetailsService {


	DoctorDetails getDoctors(String specialization);

	List<DoctorDetails> getDoctorSpec(String specialization);
	

}
