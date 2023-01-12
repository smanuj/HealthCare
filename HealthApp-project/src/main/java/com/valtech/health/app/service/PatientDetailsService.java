package com.valtech.health.app.service;

import java.util.List;
import com.valtech.health.app.entity.PatientDetails;

public interface PatientDetailsService {

	/* This method creates Patient Details */
	PatientDetails createPatientDetails(PatientDetails p);

	/* This method lists all Patient Details */
	List<PatientDetails> getAllPatientDetails();

	/* This method updates Patient Details */
	PatientDetails updatePatientsDetails(PatientDetails p);

	/* This method retrieves Patient by ID */
	PatientDetails getPatientById(int id);

}
