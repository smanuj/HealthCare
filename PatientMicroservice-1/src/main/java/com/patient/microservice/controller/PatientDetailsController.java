package com.patient.microservice.controller;

import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.microservice.entity.Comments;
import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.Hospital;
import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.facade.HospitalFacade;
import com.patient.microservice.service.CommentsService;
import com.patient.microservice.service.DoctorDetailsService;
import com.patient.microservice.service.HospitalService;
import com.patient.microservice.service.PatientDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/patients")
public class PatientDetailsController {
	@Autowired
	private PatientDetailsService patientDetailsService;
	@Autowired
	private HospitalFacade hospitalFacade;
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	@Autowired
	private CommentsService commentsService;

	@PostMapping("/create")
	public PatientDetails createPatientDetails(@RequestBody PatientDetails patient) {
		System.out.println("===========================");
		return patientDetailsService.createPatientDetails(patient);
	}

	@GetMapping("/create")
	public List<PatientDetails> getAllPatients() {
		return patientDetailsService.getAllPatients();
	}

	@GetMapping("/hospitals/pincode/{pincode}")
	public List<Hospital> getHospitalsByPincode(@PathVariable String pincode) {
		return hospitalFacade.findByPincode(pincode);
	}

	@PostMapping("/doctors/{specialization}")
	    public List<DoctorDetails> getDoctors(@PathVariable("specialization") String specialization) {
	    	return doctorDetailsService.getDoctorSpec(specialization);
	         }
	
//    @GetMapping("/comments/doctor/{doctorId}/nurse/{nurseId}")
//    public List<Comments> getComments(@PathVariable("doctorId") int doctorId , @PathVariable("nurseId") int nurseId)
//    {
//    	return commentsService.getCommentsForDoctorIdandNurseId(doctorId, nurseId);
//    }
    
    @GetMapping("/patientDetails/{id}")
    public PatientDetails getPDById(@PathVariable("id") int id) {
    	return patientDetailsService.getPatientDetailsById(id);
    }
    
   
  }

//@GetMapping("/hospitals/pincode/{pincode}")
//public List<Hospital> findByPincode(@PathVariable String pincode) {
//	logger.info("Fetching all hospitals by pincode");
//	return hospitalService.getHospitalsByPincode(pincode);
//}


//@GetMapping("/hospitals")
//public List<Hospital> getAllHospitals() {
//	logger.info("Fetching all hospital details");
//	return hospitalService.findAll();
//}


//@RestController
//@RequestMapping("/patient")
//public class PatientController {
//    @Autowired
//    private GeolocationAPI geolocationAPI;
//    @Autowired
//    private HospitalService hospitalService;
//
//    @GetMapping("/hospitals/{pincode}")
//    public List<Hospital> getHospitalsByPincode(@PathVariable String pincode) {
//        double[] latlong = geolocationAPI.getLatitudeLongitude(pincode);
//        return hospitalService.getHospitalsByLatitudeLongitude(latlong[0], latlong[1]);
//    }
//}


//@Service
//public class HospitalService {
//    @Autowired
//    private HospitalRepository hospitalRepository;
//
//    public List<Hospital> getHospitalsByLatitudeLongitude(double latitude, double longitude) {
//        return hospitalRepository.findByLatitudeAndLongitude(latitude, longitude);
//    }
//}

//public interface HospitalRepository extends JpaRepository<Hospital, Long> {
//    @Query("SELECT h FROM Hospital h WHERE h.latitude = :latitude AND h.longitude = :longitude")
//    List<Hospital> findByLatitudeAndLongitude(@Param("latitude") double latitude, @Param("longitude") double longitude);
//}







//        return commentsService.getCommentsForDoctorNurse(doctorId, nurseId}
//	
//	@GetMapping("/comment/{id}")
//	public Comments getComments(@PathVariable ("id") int id){
//		return Comments.getCommentsById(id);
//	}

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



//
//    public Patient updatePatientDetails(Patient patient, Long id) {
//        Patient existingPatient = patientRepository.findById(id).orElse(null);
//        if (existingPatient == null) {
//            throw new ResourceNotFoundException("Patient with id " + id + " not found.");
//        }
//        existingPatient.setName(patient.getName());
//        existingPatient.setAddress(patient.getAddress());
//        existingPatient.setPhone(patient.getPhone());
//        return patientRepository.save(existingPatient);
//    }
//}

