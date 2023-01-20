package com.patient.microservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.service.PatientDetailsService;


@RestController
@RequestMapping("/api/patients")
public class PatientDetailsController {
	@Autowired
	private PatientDetailsService patientDetailsService;
	@PostMapping("/create")
    public PatientDetails createPatientDetails(@RequestBody PatientDetails patient) {
        return patientDetailsService.createPatientDetails(patient);
    }
	
	 @GetMapping("/create")
    public List<PatientDetails> getAllPatients() {
        return patientDetailsService.getAllPatients();
    }
}
