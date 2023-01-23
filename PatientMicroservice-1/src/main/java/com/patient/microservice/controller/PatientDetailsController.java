package com.patient.microservice.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.Hospital;
import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.service.DoctorDetailsService;
import com.patient.microservice.service.HospitalService;
import com.patient.microservice.service.PatientDetailsService;

@RestController
@RequestMapping("/api/patients")
public class PatientDetailsController {
	@Autowired
	private PatientDetailsService patientDetailsService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private DoctorDetailsService doctorDetailsService;

	@PostMapping("/create")
	public PatientDetails createPatientDetails(@RequestBody PatientDetails patient) {
		return patientDetailsService.createPatientDetails(patient);
	}

	@GetMapping("/create")
	public List<PatientDetails> getAllPatients() {
		return patientDetailsService.getAllPatients();
	}

	@GetMapping("/hospitals/pincode/{pincode}")
	public List<Hospital> getHospitalsByPincode(@PathVariable String pincode) {
		return hospitalService.getHospitalsByPincode(pincode);
	}

	@PostMapping("/doctors/{specialization}")
	    public List<DoctorDetails> getDoctors(@PathVariable("specialization") String specialization) {
	    	return doctorDetailsService.getDoctors(specialization);
	         }

}
//	 @GetMapping("/hospitals/{pincode}")
//	 public List<Hospital> getHospitalsByPincode(@PathVariable int pincode) {
//	     return HospitalRepository.findByPincode(pincode);
//	 }
//	 @GetMapping("/doctorsAndNurses/{hospitalId}/{specialization}/{availability}")
//	 public List<DoctorAndNurse> getDoctorsAndNurses(@PathVariable int hospitalId, @PathVariable String specialization, @PathVariable boolean availability) {
//	     return doctorAndNurseRepository.findByHospitalIdAndSpecializationAndAvailability(hospitalId, specialization, availability);
//	 }

//	 @GetMapping("/hospitals/{pincode}")
//	 public ResponseEntity<List<Hospital>> getHospitalsByPincode(@PathVariable String pincode) {
//	     List<Hospital> hospitals = hospitalService.getHospitalsByPincode(pincode);
//	     return new ResponseEntity<>(hospitals, HttpStatus.OK);
//	 }
//
//}
//@RestController
//@RequestMapping("/patients")
//public class PatientController {
//
//    @Autowired
//    private PatientService patientService;
//
//    @PostMapping
//    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
//        Patient createdPatient = patientService.createPatient(patient);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Patient>> getAllPatients() {
//        List<Patient> patients = patientService.getAllPatients();
//        return ResponseEntity.ok(patients);
//    }
//}
