package com.login.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.service.entity.DoctorDetails;

public interface DoctorRepository extends JpaRepository<DoctorDetails, Integer>{
	
	List<DoctorDetails> findAllByApprovalFalseAndDoctorIdNotNull();

}
