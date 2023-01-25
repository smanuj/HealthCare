package com.login.service.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.HospitalFacade;
import com.login.service.dao.UserDao;
import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.DoctorRepository;
import com.login.service.repo.Userrepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private Userrepository userRepository;
	
	@Autowired
	private HospitalFacade hospitalfacade;
	
	@Autowired
	private UserDao userDao;


	@Override
	public DoctorDetails savedoctor(DoctorDetails doctor) {
		return doctorRepository.save(doctor);
	}
	
	
	public DoctorDetails approvingDoctor(int id) {
		DoctorDetails doctor = doctorRepository.findById(id).get();
		doctor.setApproval(true);
		return doctorRepository.save(doctor);
	}
	
	public List<DoctorDetails>  getByapprovefalse(){
		return doctorRepository.findAllByApprovalFalseAndDoctorIdNotNull();
	}

	public void deletedoctor(int id) {
		DoctorDetails doctor = doctorRepository.findById(id).get();

		List<UserDetails> users = userRepository.findAll();
	
		for(UserDetails  u: users) {
			if(u.getDoctordetails()!=null && u.getDoctordetails().getDoctorId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		doctorRepository.deleteById(doctor.getDoctorId());
	}
	
	public List<Hospital> gethospitallist(){
		return hospitalfacade.getallhospital();
	}
	
	public DoctorDetails getdoctorbyid(int id) {
		return doctorRepository.getById(id);
	}


	@Override
	public Optional<DoctorDetails> doctorgetdoctorbyid(int id) {
		return doctorRepository.findById(id);
	}
	
	
	

}
