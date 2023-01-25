package com.login.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.dao.UserDao;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.NurseRepository;
import com.login.service.repo.Userrepository;

@Service
public class NurseServiceImpl implements NurseService {
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private Userrepository userRepository;
	
	@Autowired
	private UserDao userDao;

	@Override
	public NurseDetails savenurse(NurseDetails nurse) {
		return nurseRepository.save(nurse);
	}
	
	public List<NurseDetails>  getByapprovefalse(){
		return nurseRepository.findAllByApprovalFalseAndNurseIdNotNull();
	}
	
	public NurseDetails approvingNurse(int id) {
		NurseDetails nurse = nurseRepository.findById(id).get();
		nurse.setApproval(true);
	
		return nurseRepository.save(nurse);
	}
	
	public void deletenurse(int id) {
		NurseDetails nurse = nurseRepository.findById(id).get();

		List<UserDetails> users = userRepository.findAll();
	
		for(UserDetails  u: users) {
			if(u.getNursedetails()!=null && u.getNursedetails().getId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		nurseRepository.deleteById(nurse.getId());
	
	}
	
	public Optional<NurseDetails> getnursebyid(int id) {
		return nurseRepository.findById(id);
	}
	




}
	


