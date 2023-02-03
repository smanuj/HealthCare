package com.doctor.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.NurseDetails;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.facade.Mailfacade;
import com.doctor.service.facade.Patientfacade;
import com.doctor.service.service.CommentsService;
import com.doctor.service.service.DoctorDetailsService;
import com.doctor.service.service.NurseDetailsService;
import com.doctor.service.service.PatientDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	
	@Autowired
	private PatientDetailsService patientDetailsService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private NurseDetailsService nurseDetailsService;
	
	@Autowired
	private Patientfacade patientfacade;
	
	@Autowired
	private Mailfacade mailfacade;

	
	
	
	@PostMapping("api/savecomments")
	public Comments saveComments(@RequestBody Comments comments){
		LOGGER.debug("Saving comments for patient id: {}", comments.getPatients().getId());
		comments.setComments(comments.getComments());
		comments.setPatients(comments.getPatients());
		Comments savedComments = commentsService.createComment(comments);
		LOGGER.info("Successfully saved comments for patient id: {}", comments.getPatients().getId());
		NurseDetails nurse=savedComments.getPatients().getNurseId();
		System.out.println(nurse);
		mailfacade.sendComments(savedComments);
		return savedComments;
	}
	
	@PutMapping("api/updatePatientStatus/{id}")
    public ResponseEntity<String> updatePatientStatus(@PathVariable int id) {
		LOGGER.debug("Updating patient status and availability for patient id: {}", id);
        patientDetailsService.updatePatientStatus(id);
        LOGGER.info("Successfully updated patient status and availability for patient id: {}", id);
        return ResponseEntity.ok("Patient status and availability updated successfully.");
    }
	
	 @GetMapping("api/status/{id}")
	    public boolean getPatientStatusById(@PathVariable("id") int id) {
			LOGGER.debug("Getting patient status by id: {}", id);
	        boolean status = patientDetailsService.getPatientStatusById(id);
	        LOGGER.info("Successfully retrieved patient status by id: {}", id);
	        return status;
	    }

	@GetMapping("api/comments/{id}")
	public Comments getComments(@PathVariable ("id") int id) {
		LOGGER.debug("Getting comments by id: {}", id);
		Comments comments = commentsService.getCommentsById(id);
		LOGGER.info("Successfully retrieved comments by id: {}", id);
		return comments;
	}
	
	@GetMapping("api/patientslist/{id}")
	public List<PatientDetails> getPatientList(@PathVariable ("id") DoctorDetails doctorId){
		LOGGER.debug("Getting patient list by doctor id: {}", doctorId.getDoctorId());
		List<PatientDetails> patientList = patientDetailsService.getAllPatientsByDoctorId(doctorId);
		LOGGER.info("Successfully retrieved patient list by doctor id: {}", doctorId.getDoctorId());
		return patientList;
	}
	
	@GetMapping("api/patientdetails/{id}")
	public PatientDetails getPatientDetails(@PathVariable ("id") int id){
	LOGGER.debug("Getting patient details by id: {}", id);
	PatientDetails patientDetails =patientfacade.getPatientDetailsById(id);
	LOGGER.info("Successfully retrieved patient details for id: {}", id);
	return patientDetails;
	}
	
	@GetMapping("api/doctor/{id}")
	public DoctorDetails getdoctor(@PathVariable ("id") int id){
		LOGGER.debug("Getting doctor details by id: {}", id);
		DoctorDetails doctorDetails = doctorDetailsService.getDoctorsById(id);
		LOGGER.info("Successfully retrieved doctor details for id: {}", id);
		return doctorDetails;
	}

	@GetMapping("api/specializeddoctor/{specialization}")
	public List<DoctorDetails> getdoctor(@PathVariable ("specialization") String specialization){
		LOGGER.debug("Getting all doctor details by specialization: {}", specialization);
		List<DoctorDetails> doctorDetails = doctorDetailsService.getAllDoctorsBySpecialization(specialization);
		LOGGER.info("Successfully retrieved doctor details for specialization: {}", specialization);
		return doctorDetails;
	}

	@GetMapping("api/nurse/{id}")
	public NurseDetails getnurse(@PathVariable ("id") int id){
		LOGGER.debug("Getting nurse details by id: {}", id);
		NurseDetails nurseDetails = nurseDetailsService.getNurseById(id);
		LOGGER.info("Successfully retrieved nurse details for id: {}", id);
		return nurseDetails;
	}


	@GetMapping("api/commentsbypatientid/{id}")
	public List<Comments> getCommentsByPatientId(@PathVariable ("id") PatientDetails id){
		LOGGER.debug("Getting comments by patient id: {}", id);
		List<Comments> comments = commentsService.getCommentsBypatients(id);
		LOGGER.info("Successfully retrieved comments for patient id: {}", id);
		return comments;
	}

	
	
	
}
