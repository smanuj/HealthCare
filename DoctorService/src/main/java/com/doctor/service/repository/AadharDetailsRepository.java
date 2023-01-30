package com.doctor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.AadharDetails;

@Repository
public interface AadharDetailsRepository extends JpaRepository<AadharDetails, Integer>{

}
