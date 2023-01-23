package com.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.service.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
