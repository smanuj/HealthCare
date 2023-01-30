package com.doctor.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.repository.DoctorDetailsRepository;
@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(DoctorDetailsServiceImpl.class);
	
	@Autowired
	 private DoctorDetailsRepository doctorDetailsetailsRepository;

	@Override
	public List<DoctorDetails> getAllDoctorsBySpecialization(String specialization) {
	logger.info("Retrieving doctors by specialization: {}", specialization);
	List<DoctorDetails> result = (List<DoctorDetails>) doctorDetailsetailsRepository.findBySpecialization(specialization);
	logger.debug("Result of retrieving doctors: {}", result);
	return result;
	}

	@Override
	public DoctorDetails getDoctorsById(int id) {
	logger.info("Retrieving doctor by id: {}", id);
	DoctorDetails result = doctorDetailsetailsRepository.findById(id).get();
	logger.debug("Result of retrieving doctor: {}", result);
	return result;
	}

	@Override
	public DoctorDetails saveDoctor(DoctorDetails doctorDetails) {
	logger.info("Saving doctor: {}", doctorDetails);
	DoctorDetails result = doctorDetailsetailsRepository.save(doctorDetails);
	logger.debug("Result of saving doctor: {}", result);
	return result;
	}

}
