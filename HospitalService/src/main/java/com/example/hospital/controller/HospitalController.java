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
		logger.info("Fetching all hospital details");
		return hospitalService.findAll();
	}	
	
	
	
	@PostMapping("/hospitals")
	public Hospital createHospital(@RequestBody Hospital hospital) {
		logger.info("Creating new hospital");
		return hospitalService.save(hospital);
	}
 
	 @GetMapping("/hospitals/{id}")
	  public Hospital getHospitalById(@PathVariable("id") int id) {
		   logger.info("Fetching hospital detail by id");
		   logger.debug("Fetching the hospital with id", id);
	    return hospitalService.findHospitalById(id);
	  }
	  
	  
	  @PutMapping("/hospitals/{id}")
	  public Hospital updateHospital(@RequestBody Hospital h,@PathVariable("id") int id) {
		  logger.info("Updating hospital detail");
		  logger.debug("Updating the hospital with id", id);
	    return hospitalService.updateHospital(h, id);
	    
	  }
	  
	  @DeleteMapping("/hospitals/{id}")
	  public void deleteHospital(@PathVariable("id") int id){
		   logger.info("Deleting the hospital detail by id");
		   logger.debug("Deleting the hospital with id", id);
	    hospitalService.deleteHospital(id);
	  
	  }
	  
		@GetMapping("/hospitalNames")
		public List<String> getHospital () {
			logger.info("fetching all the hospital names");
			return hospitalService.findHospitalNames();
		}
		
		@GetMapping("/admin/doctorApproval")
		public List<DoctorDetails> doctor() {
			logger.info("List of doctor details where approval is false");
			return hospitalService.getDoctorList();
		}
		
		@PostMapping("/admin/doctorApproval/{id}")
		public String doctorApproval(@PathVariable("id") int id) {
			 logger.info("Updating doctor approval as true");
			 logger.debug("Updating the doctor approval with id to true", id);
			 hospitalService.approvingDoctor(id);
			 return "Approved";
		}
		
		@DeleteMapping("/admin/doctorDisapproval/{id}")
		public String doctorDisapproval(@PathVariable("id") int id) {
			logger.info("Disapproving the doctor and deleting the doctor detail");
			logger.debug("Deleting the doctor and set approval with id to false", id);
			hospitalService.deleteDoctor(id);
			return "Disapproved";
			
		}

		
		@GetMapping("/admin/nurseApproval")
		public List<NurseDetails> nurse() {
			logger.info("List of nurse details where approval is false");
			return hospitalService.getNurseList();
		}
	
		@PostMapping("/admin/nurseApproval/{id}")
		public String nurseApproval(@PathVariable("id") int id) {
			logger.info("Updating nurse approval as true");
			logger.debug("Updating the nurse approval with id to true", id);
		        hospitalService.approvingNurse(id);
		        return "Approved";
		}
		
		
		
		@DeleteMapping("/admin/nurseDisapproval/{id}")
		public String nurseDisapproval(@PathVariable("id") int id) {
			logger.info("Disapproving the nurse and deleting the doctor detail");
			logger.debug("Deleting the nurse and set approval with id to false", id);
			hospitalService.deleteNurse(id);
			return "Disapproved";
			
		}
}
