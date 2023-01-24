package com.patient.microservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.microservice.entity.DoctorDetails;
@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Integer> {
    List<DoctorDetails> findBySpecializationAndAvaliability
    (String specialization, boolean availability);

	List<DoctorDetails> findBySpecializationAndAvaliabilityTrue(String specialization);
}
