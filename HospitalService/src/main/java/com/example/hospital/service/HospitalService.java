package com.example.hospital.service;

import java.util.List;
import com.example.hospital.exception.ResourceNotFoundException;

import com.example.hospital.entity.Hospital;

public interface HospitalService {

	List<Hospital> findAll();

	Hospital save(Hospital hospital);

	Hospital findHospitalById(int id)throws ResourceNotFoundException ;

	Hospital updateHospital(Hospital h, int id)throws ResourceNotFoundException ;

	void deleteHospital(int id);

	
}
