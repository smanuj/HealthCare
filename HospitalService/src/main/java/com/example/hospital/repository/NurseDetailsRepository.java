package com.example.hospital.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.NurseDetails;

@Repository
public interface NurseDetailsRepository extends JpaRepository<NurseDetails, Integer>{
	List<NurseDetails> findAllByApprovalFalseAndIdNotNull();
}

