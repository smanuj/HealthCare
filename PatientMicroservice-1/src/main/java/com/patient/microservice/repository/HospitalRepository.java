package com.patient.microservice.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.microservice.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByPincode(String pincode);


}
