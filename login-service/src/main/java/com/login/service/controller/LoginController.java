package com.login.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.login.service.repo.NurseRepository;
import com.login.service.repo.Userrepository;
import com.login.service.service.DoctorService;
import com.login.service.service.NurseService;
import com.login.service.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private NurseService nurseService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	

	
	@PostMapping("/api/savedoctor")
	public String user_det(@RequestBody UserDetails user) throws Exception {
		String savedoctor = userService.savedoctor(user);
		 System.out.println("pppppppppppppppppppppppppppppp");
		return savedoctor;
		
		
	}
	@PostMapping("/api/doctor")
	public DoctorDetails user(@RequestBody DoctorDetails doctor1) {
		return doctorRepository.save(doctor1);
		
		
		
	}
	@PostMapping("/api/savenurse")
	public String user_nurse(@RequestBody UserDetails user) {
		
		 String savenurse = userService.savenurse(user);
		 return savenurse;
		 
		
		
		
	}

	
	@PostMapping("/api/login")
	public String loginuser(@RequestBody UserDetails user) throws Exception{
		String loginuser = userService.loginuser(user);
		return loginuser;
	}
	

	
	@GetMapping("/doctors")
	public List<DoctorDetails> getalldoctors(){
		return doctorRepository.findAll();
	}
	
	@GetMapping("/hospitals")
	public List<Hospital> getallhospital(){
		return doctorService.gethospitallist() ;
	}

	
	@GetMapping("/hospitals/{id}")
	public Hospital getallhospitalbyid(@PathVariable("id") int hospitalId){
		
		return userService.getbyid(hospitalId) ;
	}
	
	@GetMapping("/nurse")
	public List<NurseDetails> getnursedetailsapprovalfalse(){
		return nurseService.getByapprovefalse();
	}
	
	@GetMapping("/doctor")
	public List<DoctorDetails> getdoctordetailsapprovalfalse(){
		return doctorService.getByapprovefalse();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteuser(@PathVariable("id") int userId) {
		userService.deletuser(userId);
	}
	
	@DeleteMapping("/nurse/{id}")
	public void deletenurse(@PathVariable("id") int id) {
		nurseService.deletenurse(id);
	}
	
	@DeleteMapping("/doctor/{id}")
	public void deletedoctor(@PathVariable("id") int id) {
		doctorService.deletedoctor(id);
	}
	
	@GetMapping("/doctorApproval")
	public List<DoctorDetails> doctor() {
		List<DoctorDetails> user = doctorService.getByapprovefalse();
		return user;
	}
	
	@PostMapping("/doctorApproval/{id}")
	public String doctorApproval(@PathVariable("id") int id) {
		 doctorService.approvingDoctor(id);
		 return "Approved";
	}
	
	@DeleteMapping("/doctorDisapproval/{id}")
	public String doctorDisapproval(@PathVariable("id") int id) {
		doctorService.deletedoctor(id);
		return "Disapproved";
		
	}

	
	@GetMapping("/nurseApproval")
	public List<NurseDetails> nurse() {
		List<NurseDetails> user = nurseService.getByapprovefalse();
		return user;
	}

	@PostMapping("/nurseApproval/{id}")
	public String nurseApproval(@PathVariable("id") int id) {
		 nurseService.approvingNurse(id);
		 return "Approved";
	}
	
	@DeleteMapping("/nurseDisapproval/{id}")
	public String nurseDisapproval(@PathVariable("id") int id) {
		nurseService.deletenurse(id);
		return "Disapproved";
		
	}
	

}
