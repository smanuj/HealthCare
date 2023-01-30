package com.doctor.service.service;

import java.util.List;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.PatientDetails;

public interface PatientDetailsService {

	

    List<PatientDetails> getAllPatientsByDoctorId(DoctorDetails doctorId);
    
    PatientDetails getPatientDetailsById(int id);

	PatientDetails updatePatientStatus(int patientId);

	boolean getPatientStatusById(int id);




	
		

	

	
	
}

	

