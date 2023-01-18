package com.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.service.entity.Doctor_details;

public interface DoctorRepository extends JpaRepository<Doctor_details, Integer>{

}
