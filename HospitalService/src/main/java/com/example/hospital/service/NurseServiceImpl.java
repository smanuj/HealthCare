package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.UserDao;
import com.example.hospital.entity.Nurse_details;
import com.example.hospital.entity.User_details;
import com.example.hospital.repository.Nurse_detailsRepository;
import com.example.hospital.repository.UserRepository;

@Service
public class NurseServiceImpl implements NurseService{

	@Autowired
	private Nurse_detailsRepository nurseRepository;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Nurse_details approvingNurse(int id) {
		// TODO Auto-generated method stub
		Nurse_details nurse = nurseRepository.findById(id).get();
		nurse.setApproval(true);
	
		return nurseRepository.save(nurse);
	}

	@Override
	public void deleteNurse(int id) {
		// TODO Auto-generated method stub
		Nurse_details nurse = nurseRepository.findById(id).get();

		List<User_details> users = userRepository.findAll();
	
		for(User_details  u: users) {
			if(u.getNursedetails()!=null && u.getNursedetails().getId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		nurseRepository.deleteById(nurse.getId());
	
	}
		
	}


