package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.health.app.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	/* This method finds Doctor by Doctor Name */
	Doctor findByNursename(String nursename);
}
