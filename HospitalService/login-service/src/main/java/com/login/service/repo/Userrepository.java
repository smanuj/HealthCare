package com.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.service.entity.user_details;

@Repository
public interface Userrepository extends JpaRepository<user_details, Integer>{
	
	user_details findByEmail(String email);

}
