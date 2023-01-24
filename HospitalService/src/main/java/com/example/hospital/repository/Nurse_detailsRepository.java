package com.example.hospital.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Nurse_details;

@Repository
public interface Nurse_detailsRepository extends JpaRepository<Nurse_details, Integer>{
	List<Nurse_details> findAllByApprovalFalseAndIdNotNull();
}

