package com.login.service.service;

import java.util.List;
import java.util.Optional;

import com.login.service.entity.NurseDetails;

public interface NurseService {
	
	NurseDetails savenurse(NurseDetails nurse);
	
	List<NurseDetails>  getByapprovefalse();
	
	void deletenurse(int id);
	
	NurseDetails approvingNurse(int id);
	
	Optional<NurseDetails> getnursebyid(int id);

}