package com.mail.microservice.services;

import com.mail.microservice.entity.UserDetails;

public interface UserService {

	String getRole(UserDetails user);

	boolean checkPassword(int id, String password);

	void changePassword(int id, String password);

}