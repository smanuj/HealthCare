package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.Hospital;
import com.example.hospital.entity.NurseDetails;
import com.example.hospital.service.HospitalService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class HospitalController {

	
	@Autowired
	private HospitalService hospitalService;
	
	
	@GetMapping("/hospitals")
	public List<Hospital> getAllHospitals(){
		return hospitalService.findAll();
	}		
	
	@PostMapping("/hospitals")
	public Hospital createHospital(@RequestBody Hospital hospital) {
		
		return hospitalService.save(hospital);
	}
 
	 @GetMapping("/hospitals/{id}")
	  public Hospital getHospitalById(@PathVariable("id") int id) {
	    return hospitalService.findHospitalById(id);
	  }
	  
	  
	  @PutMapping("/hospitals/{id}")
	  public Hospital updateHospital(@RequestBody Hospital h,@PathVariable("id") int id) {
	    return hospitalService.updateHospital(h, id);
	    
	  }
	  
	  @DeleteMapping("/hospitals/{id}")
	  public void deleteHospital(@PathVariable("id") int id){
	    hospitalService.deleteHospital(id);
	  
	  }
	  
		@GetMapping("/hospitalNames")
		public List<String> getHospital () {
			return hospitalService.findHospitalNames();
		}
		
		@GetMapping("/admin/doctorApproval")
		public List<DoctorDetails> doctor() {
			
			return hospitalService.getDoctorList();
		}
		
		@PutMapping("/admin/doctorApproval/{id}")
		public String doctorApproval(@PathVariable("id") int id) {
			
			 hospitalService.approvingDoctor(id);
			 return "Approved";
		}
		
		@DeleteMapping("/admin/doctorDisapproval/{id}")
		public String doctorDisapproval(@PathVariable("id") int id) {
			hospitalService.deletedoctor(id);
			return "Disapproved";
			
		}

		
		@GetMapping("/admin/nurseApproval")
		public List<NurseDetails> nurse() {
//			List<NurseDetails> user = nurse_detailsRepository.findAllByApprovalFalseAndNurseIdNotNull();
//			return user;
			return hospitalService.getNurseList();
		}
	
		@PostMapping("/admin/nurseApproval/{id}")
		public String nurseApproval(@PathVariable("id") int id) {
			 hospitalService.approvingNurse(id);
			 return "Approved";
		}
		
		
		
		@DeleteMapping("/admin/nurseDisapproval/{id}")
		public String nurseDisapproval(@PathVariable("id") int id) {
			hospitalService.deleteNurse(id);
			return "Disapproved";
			
		}
}