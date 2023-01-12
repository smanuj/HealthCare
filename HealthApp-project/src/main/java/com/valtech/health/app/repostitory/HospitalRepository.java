package com.valtech.health.app.repostitory;

import com.valtech.health.app.entity.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findByHospitalname(String hospitalName);
	
	int findIdByHospitalname(String hospitalName);
}