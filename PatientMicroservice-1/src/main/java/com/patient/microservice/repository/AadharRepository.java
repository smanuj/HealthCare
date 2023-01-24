package com.patient.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.microservice.entity.AadharDetails;

@Repository
public interface AadharRepository extends JpaRepository<AadharDetails, Integer> {

	AadharDetails findByAadharNo(int aId);
	
	

}
