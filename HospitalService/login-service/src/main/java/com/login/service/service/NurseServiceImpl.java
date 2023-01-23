package com.login.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.entity.Nurse_details;
import com.login.service.repo.NurseRepository;

@Service
public class NurseServiceImpl implements NurseService {
	
	@Autowired
	private NurseRepository nurserepository;

	@Override
	public Nurse_details savenurse(Nurse_details nurse) {
		return nurserepository.save(nurse);
	}
	

}
