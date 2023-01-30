package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.hospital.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	@Query("SELECT name FROM Hospital hospital")
	List<String> findHospitalNames();

	

	List<Hospital> findByPincode(String pincode);
	

}
