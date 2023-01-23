package com.patient.microservice.service;

import java.util.List;

import com.patient.microservice.entity.Hospital;


public interface HospitalService {


	List<Hospital> getHospitalsByPincode(String pincode);
}
