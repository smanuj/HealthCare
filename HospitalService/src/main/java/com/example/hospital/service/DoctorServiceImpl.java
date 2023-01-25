package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.UserDao;
import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.UserDetails;
import com.example.hospital.repository.DoctorDetailsRepository;
import com.example.hospital.repository.UserRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DoctorDetailsRepository doctorRepository;
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public DoctorDetails approvingDoctor(int id) {
		DoctorDetails doctor = doctorRepository.findById(id).get();
		doctor.setApproval(true);
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(int id) {
		DoctorDetails doctor = doctorRepository.findById(id).get();

		List<UserDetails> users = userRepository.findAll();
	
		for(UserDetails  u: users) {
			if(u.getDoctordetails()!=null && u.getDoctordetails().getDoctorId()==id) {
			
				userDao.deleteUser(u.getId());
			}
		}
		
		doctorRepository.deleteById(doctor.getDoctorId());
	
	}
	
	
}
