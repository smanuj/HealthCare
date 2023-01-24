package com.patient.microservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.AadharDetails;
import com.patient.microservice.entity.Comments;
import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.repository.AadharRepository;
import com.patient.microservice.repository.DoctorDetailsRepository;
import com.patient.microservice.repository.PatientDetailsRepository;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Autowired
    private PatientDetailsRepository patientRepository;
    
    @Autowired
    private AadharRepository aadharRepository;
    
    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;
     
    @Override
    public PatientDetails createPatientDetails(PatientDetails patient) {
    	int aadharNo= patient.getAadharno().getAadharNo();
    	AadharDetails a = aadharRepository.findByAadharNo(aadharNo);
    	patient.setaId(a);
    	patient.setStatus(false);
    	String spec = patient.getDisease();
    	DoctorDetails d = doctorDetailsRepository.findBySpecializationAndAvaliabilityTrue(spec);
    	patient.setDoctorId(d);
    	patient.setHospitalId(d.getHospitals());
    	Comments comm = new Comments();
    	patient.setCommentId(comm);
        return patientRepository.save(patient);
    }
    
  
    @Override
    public List<PatientDetails> getAllPatients() {
    	System.out.println(patientRepository.findAll());
        return (List<PatientDetails>) patientRepository.findAll();
    }
	
}

	

