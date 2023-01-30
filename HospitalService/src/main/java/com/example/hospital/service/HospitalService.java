package com.example.hospital.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.Hospital;
import com.example.hospital.entity.NurseDetails;

public interface HospitalService {

	List<Hospital> findAll();

	Hospital save(Hospital hospital);

	Hospital findHospitalById(int id)throws ResourceNotFoundException ;

	Hospital updateHospital(Hospital h, int id)throws ResourceNotFoundException ;

	void deleteHospital(int id);

	List<String> findHospitalNames();

	 List<DoctorDetails> getDoctorList();

	List<NurseDetails> getNurseList();
	
	String deleteDoctor(int id);
	
	String deleteNurse(int id);
	
	ResponseEntity<DoctorDetails> approvingDoctor(int id) ;
	
	ResponseEntity<NurseDetails> approvingNurse(int id);

	List<Hospital> getHospitalsByPincode(String pincode);

	void changeAvailability(int id);

	
}
