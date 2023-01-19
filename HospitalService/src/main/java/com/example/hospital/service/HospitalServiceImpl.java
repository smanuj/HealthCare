package com.example.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Hospital;
import com.example.hospital.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;
	@Override
	public List<Hospital> findAll() {
		// TODO Auto-generated method stub
		return hospitalRepository.findAll();
	}
	@Override
	public Hospital save(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalRepository.save(hospital);
	}
	@Override
	public Optional<Hospital> findById(int id) {
		// TODO Auto-generated method stub
		return hospitalRepository.findById(id);
	}
	

}
