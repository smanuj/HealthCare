package com.patient.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.patient.microservice.entity.PatientDetails;



@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer>{
	

}
