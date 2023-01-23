package com.patient.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.Hospital;
import com.patient.microservice.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	 @Autowired
	    private HospitalRepository hospitalRepository;

	 
		@Override
		public List<Hospital> getHospitalsByPincode(String pincode) {
		
			 return hospitalRepository.findByPincode(pincode);
		}

		
}
