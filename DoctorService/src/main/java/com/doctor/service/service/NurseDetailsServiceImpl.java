package com.doctor.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.NurseDetails;
import com.doctor.service.repository.NurseDetailsRepository;

@Service
public class NurseDetailsServiceImpl implements NurseDetailsService {
	@Autowired
	private NurseDetailsRepository nurseDetailsRepository;
	
	public NurseDetails getNurseById(int id) {
		return nurseDetailsRepository.findById(id).get();
	}

}
