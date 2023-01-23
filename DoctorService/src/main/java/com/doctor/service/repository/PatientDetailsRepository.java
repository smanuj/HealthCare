package com.doctor.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.PatientDetails;



@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer>{

	List<PatientDetails> findByDoctorId(DoctorDetails doctorId);
	

}
