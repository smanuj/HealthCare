package com.login.service.service;

import java.util.List;
import java.util.Optional;

import com.login.service.entity.NurseDetails;

public interface NurseService {
	
	NurseDetails saveNurse(NurseDetails nurse);
	
	List<NurseDetails>  getByapprovefalse();
	
	void deleteNurse(int id);
	
	NurseDetails approvingNurse(int id);
	
	Optional<NurseDetails> getNurseById(int id);

}