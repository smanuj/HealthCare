package com.example.hospital.service;

import java.util.List;
import java.util.Optional;

import com.example.hospital.entity.Hospital;

public interface HospitalService {

	List<Hospital> findAll();

	Hospital save(Hospital hospital);

	Optional<Hospital> findById(int id);

	
}
