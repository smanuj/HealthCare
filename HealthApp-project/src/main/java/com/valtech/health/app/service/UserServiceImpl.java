package com.valtech.health.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.valtech.health.app.entity.User;
import com.valtech.health.app.repostitory.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	 
 public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

	/* This method creates new nurse */
 @Override
 public User createUser(User u) {
     String encodedPassword = this.bCryptPasswordEncoder.encode(u.getPassword());
     u.setPassword(encodedPassword);
     return this.userRepository.save(u);
 }

	
	/* This method finds nurse by email */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	/* This method finds nurse by email */
	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	/* This method finds nurse by user name */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/* This method finds nurse by password */
	@Override
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	/* This method retrieves user name by id */
	@Override
	public User getUsername(int id) {
		// TODO Auto-generated method stub
		return userRepository.findUsernameById(id);
	}

	/* This method retrieves id by user name */
	@Override
	public int getIdbyUsername(String username) {
		User u = userRepository.findByUsername(username);
		return u.getId();
	}

	@Override
	public User changePassword(User u, String password) {
		// TODO Auto-generated method stub
		u.setPassword(password);
		return userRepository.save(u);
	}

	@Override
	public String getEmailByName(String doctorsname) {
		User u = userRepository.findByName(doctorsname);
		return u.getEmail();
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	

	@Override
	public void setOtp(User u, int otp) {
		// TODO Auto-generated method stub
		u.setOtp(otp);
		userRepository.save(u);
	}

	@Override
	public User findByOtp(int otp) {
		return userRepository.findByOtp(otp);
	}

	@Override
	public String findPasswordByUsername(String username) {
		User u = userRepository.findByUsername(username);
		return u.getPassword();
	}

	@Override
	public String getRole(String username) {
		User u = userRepository.findByUsername(username);
		return u.getRole();
	}

	@Override
	public int getId(String username) {
		User u = userRepository.findByUsername(username);
		return u.getId();
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	
	
}
