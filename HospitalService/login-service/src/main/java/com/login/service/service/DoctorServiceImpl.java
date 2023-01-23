package com.login.service.service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.entity.Doctor_details;
import com.login.service.repo.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorrepository;

	@Override
	public Doctor_details savedoctor(Doctor_details doctor) {
		return doctorrepository.save(doctor);
	}
	
	

}
