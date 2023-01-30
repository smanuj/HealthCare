package com.patient.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer>{

	UserDetails findByDoctorDetails(DoctorDetails d);

}
