package com.login.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.entity.NurseDetails;
import com.login.service.repo.NurseRepository;

@Service
public class NurseServiceImpl implements NurseService {
	
	@Autowired
	private NurseRepository nurserepository;

	@Override
	public NurseDetails savenurse(NurseDetails nurse) {
		return nurserepository.save(nurse);
	}
	
	public List<NurseDetails>  getByapprovefalse(){
		return nurserepository.findAllByApprovalFalseAndNurseIdNotNull();
	}
	
	public void deletenurse(int id) {
		nurserepository.deleteById(id);
	}
	

}
