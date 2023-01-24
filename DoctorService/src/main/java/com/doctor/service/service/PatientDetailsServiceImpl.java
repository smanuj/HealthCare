package com.doctor.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.repository.PatientDetailsRepository;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Autowired
    private PatientDetailsRepository patientRepository;


	@Override
	public List<PatientDetails> getAllPatientsByDoctorId(DoctorDetails doctorId) {
		return (List<PatientDetails>) patientRepository.findByDoctorId( doctorId);
	}


	@Override
	public PatientDetails getPatientDetailsById(int id) {
		return patientRepository.findById(id).get();
	}
 
    
  
    
	
}

