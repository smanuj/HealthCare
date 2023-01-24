package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.DoctorDetails;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Integer>{
	
	List<DoctorDetails> findAllByApprovalFalseAndIdNotNull();
}
