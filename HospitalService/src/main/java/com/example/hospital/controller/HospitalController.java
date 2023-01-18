package com.example.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.hospital.repository.HospitalRepository;
import com.example.hospital.service.HospitalService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
@RestController
public class HospitalController {
	@Autowired
	private HospitalRepository hospitalRepository;
	
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
	public ResponseEntity<Hospital> getHospitalById(@PathVariable int id) {
		Hospital hospital = hospitalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id :" + id));
		return ResponseEntity.ok(hospital);
	}
	
	
	
	@PutMapping("/hospitals/{id}")
	public ResponseEntity<Hospital> updateHospital(@PathVariable int id, @RequestBody Hospital hospitaldetails){
		Hospital hospital = hospitalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id :" + id));
		
		hospital.setName(hospitaldetails.getName());
		hospital.setContact_number(hospitaldetails.getContact_number());
		hospital.setLocation(hospitaldetails.getLocation());
		hospital.setPincode(hospitaldetails.getPincode());
	
		Hospital updatedHospital = hospitalRepository.save(hospital);
		return ResponseEntity.ok(updatedHospital);
	}
	

	@DeleteMapping("/hospitals/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteHospital(@PathVariable int id){
		Hospital hospital= hospitalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not exist with id :" + id));
		
		hospitalRepository.delete(hospital);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
}
