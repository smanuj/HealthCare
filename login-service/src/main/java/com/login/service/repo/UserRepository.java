package com.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
	UserDetails findByEmail(String email);
	
	UserDetails findByDoctorDetails(DoctorDetails doctor);
	
	UserDetails findByNurseDetails(NurseDetails nurse);

}
