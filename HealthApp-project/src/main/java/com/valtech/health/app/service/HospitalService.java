package com.valtech.health.app.service;

import java.util.List;

import com.valtech.health.app.entity.Hospital;


public interface HospitalService {

	/* This method creates Hospital */
	Hospital createHospital(Hospital h);

	/* This method lists all Hospitals */
	List<Hospital> getAllHospitals();

	/* This method updates Hospital Details */
	Hospital updateHospitalDetails(Hospital h);

	/* This method retrieves Hospitals by ID */
	Hospital getHospitalById(int id);
	
	/* This method deletes Hospitals by ID */
	void deleteHospitalById(int id);

	Hospital findByHospitalname(String hospitalName);
	
//	Hospital getidbyhospitalname(String h);

	

}