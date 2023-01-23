package com.doctor.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.repository.DoctorDetailsRepository;
@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService{
	@Autowired
	 private DoctorDetailsRepository doctorDetailsetailsRepository;

	@Override
	public List<DoctorDetails> getAllDoctorsBySpecialization(String specialization) {
		return  (List<DoctorDetails>) doctorDetailsetailsRepository.findBySpecialization(specialization);
	}

	@Override
	public DoctorDetails getDoctorsById(int id) {
		return doctorDetailsetailsRepository.findById(id).get();
	}

	@Override
	public DoctorDetails saveDoctor(DoctorDetails doctorDetails) {
		return doctorDetailsetailsRepository.save(doctorDetails);
	}

}
