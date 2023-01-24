package com.login.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.service.entity.NurseDetails;

@Repository
public interface NurseRepository  extends JpaRepository<NurseDetails, Integer>{
	
	List<NurseDetails> findAllByApprovalFalseAndNurseIdNotNull();

}
