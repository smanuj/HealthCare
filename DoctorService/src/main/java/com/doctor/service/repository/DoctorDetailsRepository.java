package com.doctor.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.PatientDetails;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Integer>{

	List<DoctorDetails> findBySpecialization(String specialization);

	Optional<PatientDetails> findBydoctorId(int doctorId);
	
	



}
