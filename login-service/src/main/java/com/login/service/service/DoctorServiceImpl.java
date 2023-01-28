package com.login.service.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.dao.UserDao;
import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.facade.HospitalFacade;
import com.login.service.repo.DoctorRepository;
import com.login.service.repo.UserRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HospitalFacade hospitalfacade;

	@Autowired
	private UserDao userDao;

// Creating new Doctor
	@Override
	public DoctorDetails saveDoctor(DoctorDetails doctor) {
		logger.info("Creating new doctor");
		DoctorDetails doctor1 = doctorRepository.save(doctor);
		logger.debug("Details of new nurse created", doctor1);
		return doctor1;
	}

	// Updating Doctor approve as true
	public DoctorDetails approvingDoctor(int id) {
		logger.info("Fetching doctor details by id");
		DoctorDetails doctor = doctorRepository.findById(id).get();
		logger.info("Updating doctor approve as true");
		doctor.setApproval(true);
		logger.debug("Updated details of doctor", doctor);
		return doctorRepository.save(doctor);
	}

	// Fetching Doctordetails where approve is false
	public List<DoctorDetails> getByapprovefalse() {
		logger.info("Fetching doctor details where approval is false");
		return doctorRepository.findAllByApprovalFalseAndDoctorIdNotNull();
	}

//	Deleting Doctor detail by id
	public void deleteDoctor(int id) {
		logger.info("Fetching doctor detail by id");
		DoctorDetails doctor = doctorRepository.findById(id).get();
		List<UserDetails> users = userRepository.findAll();

		for (UserDetails u : users) {
			if (u.getDoctordetails() != null && u.getDoctordetails().getDoctorId() == id) {

				userDao.deleteUser(u.getId());
			}
		}

		doctorRepository.deleteById(doctor.getDoctorId());
	}

//Fetching hospital details with help of hospital facade	
	public List<Hospital> getHospitalList() {
		logger.info("Fetching hoospital details");
		return hospitalfacade.getAllHospital();
	}

//	Fetching doctor detail by id
	public DoctorDetails getDoctorById(int id) {
		logger.info("Fetching doctor details by id");
		return doctorRepository.getById(id);
	}

//Fetching doctor detail by id
	@Override
	public Optional<DoctorDetails> doctorgetdoctorbyid(int id) {
		logger.info("Fetching doctor details by id");
		return doctorRepository.findById(id);
	}

}
