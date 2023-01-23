package com.login.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.DoctorRepository;
import com.login.service.repo.HospitalRepository;
import com.login.service.repo.NurseRepository;
import com.login.service.repo.Userrepository;
import com.login.service.service.DoctorService;
import com.login.service.service.NurseService;
import com.login.service.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private DoctorService doctorservice;
	
	@Autowired
	private NurseService nurseservice;
	
	@Autowired
	private DoctorRepository doctor;
	
	@Autowired
	private HospitalRepository hospital;
	

	
	@PostMapping("/api/savedoctor")
	public String user_det(@RequestBody UserDetails user) throws Exception {
		String savedoctor = userservice.savedoctor(user);
		 
		return savedoctor;
		
		
	}
	@PostMapping("/api/doctor")
	public DoctorDetails user(@RequestBody DoctorDetails doctor1) {
		return doctor.save(doctor1);
		
		
		
	}
	@PostMapping("/api/savenurse")
	public String user_nurse(@RequestBody UserDetails user) {
		
		 String savenurse = userservice.savenurse(user);
		 return savenurse;
		 
		
		
		
	}

	
	@PostMapping("/api/login")
	public String loginuser(@RequestBody UserDetails user) throws Exception{
		String loginuser = userservice.loginuser(user);
		return loginuser;
	}
	

	
	@GetMapping("/doctors")
	public List<DoctorDetails> getalldoctors(){
		return doctor.findAll();
	}
	
	@GetMapping("/hospitals")
	public List<Hospital> getallhospital(){
		return hospital.findAll() ;
	}
	

}
