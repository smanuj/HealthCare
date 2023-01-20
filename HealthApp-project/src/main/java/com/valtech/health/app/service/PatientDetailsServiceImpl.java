package com.valtech.health.app.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.health.app.entity.PatientDetails;
import com.valtech.health.app.repostitory.PatientDetailsRepository;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
	@Autowired
	private PatientDetailsRepository patientDetailsRepository;

	/* This method creates Patient Details */
	@Override
	public PatientDetails createPatientDetails(PatientDetails p) {
		//p.setDate(LocalDate.now());
		p.setPdate(LocalDateTime.now());
		return patientDetailsRepository.save(p);
	}

	/* This method lists all Patient Details */
	@Override
	public List<PatientDetails> getAllPatientDetails() {
		return patientDetailsRepository.findAll();
	}
	

	/* This method retrieves Patient by ID */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PatientDetails getPatientById(int id) {
		return patientDetailsRepository.getReferenceById(id);
	}

	/* This method updates Patient Details */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PatientDetails updatePatientsDetails(PatientDetails p) {
		// TODO Auto-generated method stub
		p.setPdate(LocalDateTime.now());
		return patientDetailsRepository.save(p);
	}
}
