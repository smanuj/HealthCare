package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.UserDao;
import com.example.hospital.entity.Doctor_details;
import com.example.hospital.entity.User_details;
import com.example.hospital.repository.Doctor_detailsRepository;
import com.example.hospital.repository.UserRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Doctor_detailsRepository doctorRepository;
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public Doctor_details approvingDoctor(int id) {
		Doctor_details doctor = doctorRepository.findById(id).get();
		doctor.setApproval(true);
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(int id) {
		Doctor_details doctor = doctorRepository.findById(id).get();

		List<User_details> users = userRepository.findAll();
	
		for(User_details  u: users) {
			if(u.getDoctordetails()!=null && u.getDoctordetails().getId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		doctorRepository.deleteById(doctor.getId());
	
	}
}
