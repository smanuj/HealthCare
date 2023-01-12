package com.valtech.health.app.service;

import java.util.List;

import com.valtech.health.app.entity.User;

public interface UserService {

	/* This method creates new nurse */
	User createUser(User u);

	/* This method finds nurse by email */
	User findByEmail(String email);

	/* This method finds nurse by user name */
	User findByUsername(String username);

	/* This method finds nurse by password */
	User findByPassword(String password);

	/* This method retrieves id by user name */
	int getIdbyUsername(String string);

	/* This method retrieves user name by id */
	User getUsername(int id);


	User changePassword(User u, String password);

	String getEmailByName(String doctorsname);

	User findByName(String name);
	
	/* This method lists all the doctors */
	List<User> getAllUsers();
	
	/*List<User> getAllDoctorUsers(User u);*/

	
	void setOtp(User u, int otp);

	User findByOtp(int otp);

	String findPasswordByUsername(String username);

	String getRole(String username);

	int getId(String username);

	User findById(int id);





}