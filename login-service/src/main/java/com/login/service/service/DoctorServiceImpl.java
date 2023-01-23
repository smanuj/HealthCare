package com.login.service.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.repo.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorrepository;
	
	


	@Override
	public DoctorDetails savedoctor(DoctorDetails doctor) {
		return doctorrepository.save(doctor);
	}

	
	

}
