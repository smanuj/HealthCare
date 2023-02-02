package com.login.service.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.dao.UserDao;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.NurseRepository;
import com.login.service.repo.UserRepository;

@Service
public class NurseServiceImpl implements NurseService {

	private static final Logger logger = LoggerFactory.getLogger(NurseServiceImpl.class);

	@Autowired
	private NurseRepository nurseRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;

//	Creating new Nurse
	@Override
	public NurseDetails saveNurse(NurseDetails nurse) {
		logger.info("creating new Nurse");
		NurseDetails nurse1 = nurseRepository.save(nurse);
		logger.debug("Details of new nurse created", nurse1);
		return nurse1;
	}

//Fetching Nursedetails where approve is false	
	public List<NurseDetails> getByapprovefalse() {
		logger.info("Fetching nurse details where approve is false");
		return nurseRepository.findAllByApprovalFalseAndNurseIdNotNull();
	}

//Updating nurse approve as true	
	public NurseDetails approvingNurse(int id) {
		logger.info("Updating nurse approve as true");
		NurseDetails nurse = nurseRepository.findById(id).get();
		nurse.setApproval(true);
		logger.debug("Updated details of nurse", nurse);
		return nurseRepository.save(nurse);
	}

//	Deleting Nurse detail by id
	public void deleteNurse(int id) {
		logger.info("Fetching nurse detail by id");
		NurseDetails nurse = nurseRepository.findById(id).get();

		List<UserDetails> users = userRepository.findAll();

		for (UserDetails u : users) {
			if (u.getNursedetails() != null && u.getNursedetails().getNurseId() == id) {

				userDao.deleteUser(u.getId());
			}
		}

		nurseRepository.deleteById(nurse.getNurseId());

	}

//	Fetching nurse detail by id
	public Optional<NurseDetails> getNurseById(int id) {
		logger.info("Fetching nurse detail by id");
		return nurseRepository.findById(id);
	}
	
	

}
