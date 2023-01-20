package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.Hospital;
import com.example.hospital.exception.ResourceNotFoundException;
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
	  public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") int id) throws ResourceNotFoundException{
	    return new ResponseEntity<Hospital>(hospitalService.findHospitalById(id),HttpStatus.OK);
	  }
	  
	  
	  @PutMapping("/hospitals/{id}")
	  public ResponseEntity<Hospital> updateHospital(@RequestBody Hospital h,@PathVariable("id") int id) throws ResourceNotFoundException{
	    return new ResponseEntity<Hospital>(hospitalService.updateHospital(h, id), HttpStatus.OK);
	    
	  }
	  
	  @DeleteMapping("/hospitals/{id}")
	  public ResponseEntity<String> deleteHospital(@PathVariable("id") int id){
	    hospitalService.deleteHospital(id);
	    return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	  }
	  
}