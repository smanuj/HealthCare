package com.patient.microservice.service;

import java.util.List;


import com.patient.microservice.entity.PatientDetails;

public interface PatientDetailsService {

	

    List<PatientDetails> getAllPatients();

	PatientDetails createPatientDetails(PatientDetails patient);

	void treatmentComplete(PatientDetails pd);

	PatientDetails getPatientDetailsById(int id);



	
		

	

	
	
}

	

