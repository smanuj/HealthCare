package com.patient.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.Hospital;
import com.patient.microservice.repository.DoctorDetailsRepository;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
    private DoctorDetailsRepository doctorRepository;

	@Override
    public DoctorDetails getDoctors(String specialization) {
        return doctorRepository.findBySpecializationAndAvaliabilityTrue(specialization);
    }
	
	@Override
	public List<DoctorDetails> getDoctorSpec(String specialization){
		return doctorRepository.findAllBySpecializationAndAvaliabilityTrue(specialization);
	}
	
}
