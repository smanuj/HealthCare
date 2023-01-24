package com.doctor.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.DoctorDetails;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Integer>{

	List<DoctorDetails> findBySpecialization(String specialization);

}
