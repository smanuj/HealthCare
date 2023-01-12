package com.valtech.health.app.repostitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.health.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/* This method finds user by email */
	User findByEmail(String email);
	
	/* This method finds user by id */
	User findById(int id);

	/* This method finds user by user name */
	User findByUsername(String username);

	/* This method finds user by password */
	User findByPassword(String password);

	/* This method retrieves user name by id */
	User findUsernameById(int id);

	/* This method retrieves user name by id */
	User findIdByUsername(String username);

	/* This method finds user by name */
	User findByName(String name);

	/* This method finds user by otp */
	User findByOtp(int otp);

	
}
