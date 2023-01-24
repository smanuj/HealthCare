package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.UserDao;
import com.example.hospital.entity.NurseDetails;
import com.example.hospital.entity.UserDetails;
import com.example.hospital.repository.NurseDetailsRepository;
import com.example.hospital.repository.UserRepository;

@Service
public class NurseServiceImpl implements NurseService{

	@Autowired
	private NurseDetailsRepository nurseRepository;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public NurseDetails approvingNurse(int id) {
		// TODO Auto-generated method stub
		NurseDetails nurse = nurseRepository.findById(id).get();
		nurse.setApproval(true);
	
		return nurseRepository.save(nurse);
	}

	@Override
	public void deleteNurse(int id) {
		NurseDetails nurse = nurseRepository.findById(id).get();

		List<UserDetails> users = userRepository.findAll();
	
		for(UserDetails  u: users) {
			if(u.getNursedetails()!=null && u.getNursedetails().getId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		nurseRepository.deleteById(nurse.getId());
	
	}
		
	}


