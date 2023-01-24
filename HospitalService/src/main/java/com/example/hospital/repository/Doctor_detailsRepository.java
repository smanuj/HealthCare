package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Doctor_details;

@Repository
public interface Doctor_detailsRepository extends JpaRepository<Doctor_details, Integer>{
	
	List<Doctor_details> findAllByApprovalFalseAndIdNotNull();
}
