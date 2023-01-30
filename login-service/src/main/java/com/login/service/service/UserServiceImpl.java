package com.login.service.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.service.config.WebSecurityConfig;
import com.login.service.dao.UserDao;
import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.facade.HospitalFacade;
import com.login.service.repo.DoctorRepository;
import com.login.service.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private NurseService nurseService;

	@Autowired
	private HospitalFacade hospitalFacade;

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@Autowired
	private UserDao userDao;

	
//	Fetching user detail by email
	@Override
	public UserDetails getByEmail(String email) {
		logger.info("Fetching Userdetails by email");
		UserDetails user = userRepository.findByEmail(email);
		logger.debug("UserDetails of "+email+"is ", user);
		return user;
		
	}
// Creating new user
	@Override
	public UserDetails saveUser(UserDetails user) {
		logger.info("creating new  user ");
		return userRepository.save(user);
	}

//	Fetching all User Details
	@Override
	public List<UserDetails> getalluser() {
		logger.info("Fetching all user details");
		return userRepository.findAll();
		
	}
//First we will fetch all user details 
//	Then we find whether the email is already registered or not , if registered then the flag value is set to 1
//	If flag value is not 1 , then we create new doctor and user
	@Override
	public String saveDoctor(UserDetails user) throws Exception {
		int flag = 0;
		try {
			logger.info("Fetching all user details");
			List<UserDetails> users = userRepository.findAll();
			for (UserDetails user1 : users) {
				logger.info("Finding whether the email is registered or not");
				if (user1.getEmail().equals(user.getEmail())) {
					flag = 1;
				}
			}
			if (flag == 1) {
				return "not";
			}
			DoctorDetails doctor = user.getDoctordetails();
			int hospitalId = doctor.getHospital().getHospitalId();
			Hospital hospital = hospitalFacade.getHospitalById(hospitalId);
			doctor.setApproval(false);
			doctor.setAvaliability(true);
			doctor.setHospital(hospital);
			logger.info("creating new doctor details");
			DoctorDetails doctor1 = doctorService.saveDoctor(doctor);
			String dd = webSecurityConfig.passwordEncoder().encode(user.getPassword());
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), doctor1);
			logger.info("creating new user");
			userRepository.save(user2);
			return "saved";
		}

		catch (Exception e) {

			DoctorDetails doctor = user.getDoctordetails();
			int hospitalId = doctor.getHospital().getHospitalId();
			Hospital hospital = hospitalFacade.getHospitalById(hospitalId);
			doctor.setApproval(false);
			doctor.setAvaliability(true);
			doctor.setHospital(hospital);
			logger.info("creating new doctor details");
			DoctorDetails doctor1 = doctorService.saveDoctor(doctor);
			String dd = webSecurityConfig.passwordEncoder().encode(user.getPassword());
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), doctor1);
			logger.info("creating new user");
			userRepository.save(user2);
			return "saved";
		}
	}
	//First we will fetch all user details 
//	Then we find whether the email is already registered or not , if registered then the flag value is set to 1
//	If flag value is not 1 , then we create new nurse and user
	@Override
	public String saveNurse(UserDetails user) throws Exception {
		int flag = 0;
		try {
			logger.info("Fetching all user details");
			List<UserDetails> users = userRepository.findAll();
			for (UserDetails user1 : users) {
				if (user1.getEmail().equals(user.getEmail())) {
					logger.info("Finding whether the email is registered or not");
					flag = 1;

				}
			}
			if (flag == 1) {
				return "not";
			}
			NurseDetails nurse = user.getNursedetails();
			nurse.setApproval(false);
			nurse.setAvaliability(true);
			logger.info("creating new nurse details");
			NurseDetails nurse1 = nurseService.saveNurse(nurse);
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), nurse1);
			logger.info("creating new user");
			userRepository.save(user2);
			return "saved";
		} catch (Exception e) {
			NurseDetails nurse = user.getNursedetails();
			nurse.setApproval(false);
			nurse.setAvaliability(true);
			logger.info("creating new nurse details");
			NurseDetails nurse1 = nurseService.saveNurse(nurse);
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), nurse1);
			logger.info("creating new user");
			userRepository.save(user2);
			return "saved";

		}

	}
	
// First we will check whether the email and password is admin , If it is then it will redirect to admin dashboard
// If it is not then it will get all User detail by email and check for doctor details , if doctor details is not null check password 
//	, password is correct and approval is true then it is redirect to doctor dashboard
//If doctor details is null then it will check for nurse details , if nurse details is not null ,it check for password and approval and redirect 
//	to nurse dashboard
//If Nurse Details is null then it will return email is not reistered

	@Override
	public String loginUser(UserDetails user) throws Exception {
		String password = user.getPassword();
		String email = user.getEmail();
		logger.info("Checking whether the email and password belongs to admin");
		if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("admin")) {
			
                             return "admindashboard";
                   }
		try {
			UserDetails user2 = userRepository.findByEmail(email);
			if (user2 != null) {
				DoctorDetails doctor = user2.getDoctordetails();
				if (doctor == null) {
					NurseDetails nurse = user2.getNursedetails();
					logger.info("Checking registered password and given password of nurse is correct or not");
					if (webSecurityConfig.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
						logger.info("Checking whether nurse has benn  approval or not");
						if (nurse.isApproval()) {
							return "nurse";
						} else {
							return "wait";
						}
					} else {
						return "pass";
					}
				}

				else {
					logger.info("Checking registered password and given password of doctor is correct or not");
					if (webSecurityConfig.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
						logger.info("Checking whether doctor has benn  approval or not");
						if (doctor.isApproval()) {
							return "doctor";
						} else {
							return "wait";
						}
					} else {
						return "pass";
					}
				}
			} else {
				return "failed";
			}
		} catch (Exception e) {
			logger.info("Returning the email has not been registered");
			return "failed";
		}

	}
	

//Deleting user detail by id
	@Override
	public void deletUser(int id) {
		logger.info("Deleting the user detail bu id");
		userDao.deleteUser(id);

	}
// Fetching hospital detial by id from hospital-microservice with helkp of hospital facade
	public Hospital getById(int id) {
		logger.info("Fetching hospital detail by id");
		Hospital hospital= hospitalFacade.getHospitalById(id);
		logger.debug("Detail of hospital "+id+" ",hospital);
		return hospital;
	}
//Finding the role of user 
	public String getRole(UserDetails user) {
		logger.info("Finding the role by user details");
		if (user.getDoctordetails() != null) {
			return "doctor";
		} else if (user.getNursedetails() != null) {
			return "nurse";
		}
		return "admin";
	}
//Checking whether the otp sent to user is same as the otp which is entered during changepassword 
	public boolean checkPassword(int id, String password) {
		logger.info("Fetching user detail by id");
		UserDetails u = userRepository.findById(id).get();
		logger.debug("user detail ",u);
		if (webSecurityConfig.passwordEncoder().matches(password, u.getPassword())) {
			return true;
		}
		return false;
	}
//Updating new password 
	public void changePassword(int id, String password) {
		logger.info("Fetching user detail by id");
		UserDetails u = userRepository.findById(id).get();
		logger.debug("user detail ",u);
		u.setPassword(password);
		userRepository.save(u);

	}
// Finding user detail by id
	@Override
	public UserDetails findById(int id) {
		logger.info("Fetching user detail by id");
		return userRepository.findById(id).get();
	}
//	Returning doctor id
	@Override
	public int doctorlogin(String email) {
		UserDetails user1 = userRepository.findByEmail(email);
		DoctorDetails doctor = user1.getDoctordetails();
		int id= doctor.getDoctorId();
		return id;
	}
//	Returning nurse id	
	@Override
	public int nurselogin(String email) {
		UserDetails user1 = userRepository.findByEmail(email);
		NurseDetails nurse = user1.getNursedetails();
		int id = nurse.getNurseId();
		return id;
	}
	
	@Override
	public UserDetails getbydoctordetails(DoctorDetails doctor) {
		return userRepository.findByDoctorDetails(doctor);
	}

}
