package com.example.hospital.service;

import java.util.List;

import com.example.hospital.entity.Hospital;

public interface HospitalService {

	List<Hospital> findAll();

	Hospital save(Hospital hospital);

	

}
