package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.health.app.entity.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

}
