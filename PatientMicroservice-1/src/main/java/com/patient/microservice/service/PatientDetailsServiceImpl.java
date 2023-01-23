package com.patient.microservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.repository.PatientDetailsRepository;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Autowired
    private PatientDetailsRepository patientRepository;
     
    @Override
    public PatientDetails createPatientDetails(PatientDetails patient) {
        return patientRepository.save(patient);
    }
    
  
    @Override
    public List<PatientDetails> getAllPatients() {
    	System.out.println(patientRepository.findAll());
        return (List<PatientDetails>) patientRepository.findAll();
    }
	
}

	

