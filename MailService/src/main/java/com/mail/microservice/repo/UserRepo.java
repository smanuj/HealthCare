package com.mail.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.microservice.entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer>{

	UserDetails findByEmail(String email);
	
}
