package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
