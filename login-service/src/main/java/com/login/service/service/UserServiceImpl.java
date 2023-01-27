package com.login.service.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

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

	@Override
	public UserDetails getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails saveUser(UserDetails user) {
		return userRepository.save(user);
	}

	@Override
	public List<UserDetails> getalluser() {
		return userRepository.findAll();
	}

	@Override
	public String saveDoctor(UserDetails user) throws Exception {
		int flag = 0;
		try {
			List<UserDetails> users = userRepository.findAll();
			for (UserDetails user1 : users) {
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
			DoctorDetails doctor1 = doctorService.saveDoctor(doctor);
			String dd = webSecurityConfig.passwordEncoder().encode(user.getPassword());
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), doctor1);
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
			DoctorDetails doctor1 = doctorService.saveDoctor(doctor);
			String dd = webSecurityConfig.passwordEncoder().encode(user.getPassword());
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), doctor1);
			userRepository.save(user2);
			return "saved";
		}
	}

	@Override
	public String saveNurse(UserDetails user) throws Exception {
		int flag = 0;
		try {
			List<UserDetails> users = userRepository.findAll();
			for (UserDetails user1 : users) {
				if (user1.getEmail().equals(user.getEmail())) {

					flag = 1;

				}
			}
			if (flag == 1) {
				return "not";
			}
			NurseDetails nurse = user.getNursedetails();
			nurse.setApproval(false);
			nurse.setAvaliability(true);
			NurseDetails nurse1 = nurseService.saveNurse(nurse);
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), nurse1);
			userRepository.save(user2);
			return "saved";
		} catch (Exception e) {
			NurseDetails nurse = user.getNursedetails();
			nurse.setApproval(false);
			nurse.setAvaliability(true);
			NurseDetails nurse1 = nurseService.saveNurse(nurse);
			UserDetails user2 = new UserDetails(user.getEmail(),
					webSecurityConfig.passwordEncoder().encode(user.getPassword()), nurse1);
			userRepository.save(user2);
			return "saved";

		}

	}

	@Override
	public String loginUser(UserDetails user) throws Exception {
		String password = user.getPassword();
		String email = user.getEmail();
		try {
			UserDetails user2 = userRepository.findByEmail(email);
			if (user2 != null) {
				DoctorDetails doctor = user2.getDoctordetails();
				if (doctor == null) {
					NurseDetails nurse = user2.getNursedetails();
					if (webSecurityConfig.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
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
					System.out.println(
							webSecurityConfig.passwordEncoder().matches(user.getPassword(), user2.getPassword()));
					if (webSecurityConfig.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
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
			return "failed";
		}

	}
	


	@Override
	public void deletUser(int id) {
		userDao.deleteUser(id);

	}

	public Hospital getById(int id) {
		return hospitalFacade.getHospitalById(id);
	}

	public String getRole(UserDetails user) {
		if (user.getDoctordetails() != null) {
			return "doctor";
		} else if (user.getNursedetails() != null) {
			return "nurse";
		}
		return "admin";
	}

	public boolean checkPassword(int id, String password) {
		UserDetails u = userRepository.findById(id).get();
		if (webSecurityConfig.passwordEncoder().matches(password, u.getPassword())) {
			return true;
		}
		return false;
	}

	public void changePassword(int id, String password) {
		UserDetails u = userRepository.findById(id).get();
		u.setPassword(password);
		userRepository.save(u);

	}

	@Override
	public UserDetails findById(int id) {
		return userRepository.findById(id).get();
	}

}
