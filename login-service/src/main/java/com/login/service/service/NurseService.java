package com.login.service.service;

import java.util.List;

import com.login.service.entity.NurseDetails;

public interface NurseService {
	
	NurseDetails savenurse(NurseDetails nurse);
	
	List<NurseDetails>  getByapprovefalse();
	
	void deletenurse(int id);
	
	NurseDetails approvingNurse(int id);

}