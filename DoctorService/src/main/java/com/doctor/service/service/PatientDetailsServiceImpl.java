package com.doctor.service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.NurseDetails;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.repository.DoctorDetailsRepository;
import com.doctor.service.repository.NurseDetailsRepository;
import com.doctor.service.repository.PatientDetailsRepository;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);

	@Autowired
	private NurseDetailsRepository nurseDetailsRepository;
	
	@Autowired
	private DoctorDetailsRepository doctorDetailsRepository;
	
    @Autowired
    private PatientDetailsRepository patientRepository;


	@Override
	public List<PatientDetails> getAllPatientsByDoctorId(DoctorDetails doctorId) {
		LOGGER.info("Retrieving all patients for doctor with ID: {}", doctorId.getDoctorId());
	    List<PatientDetails> patients = patientRepository.findByDoctorId(doctorId);
	    LOGGER.debug("Retrieved {} patients for doctor with ID: {}", patients.size(), doctorId.getDoctorId());
	    return patients;	
	}


	@Override
	public PatientDetails getPatientDetailsById(int id) {
		LOGGER.debug("Getting patient details by id: {}", id);
		return patientRepository.findById(id).get();
	}
	
	@Transactional
	@Override
	public PatientDetails updatePatientStatus(int patientId) {
		LOGGER.trace("Updating patient status for patient id: {}", patientId);
	    PatientDetails patient = patientRepository.findById(patientId).get();
	    patient.setStatus(true);
	    patientRepository.save(patient);
	    int id=patient.getNurseId().getId();
	    NurseDetails nurse = nurseDetailsRepository.findBynurseId(id).get();
	    nurse.setAvaliability(true);
	    nurseDetailsRepository.save(nurse);
	    int doctorId=patient.getDoctorId().getDoctorId();
	    DoctorDetails doctor=doctorDetailsRepository.findById(doctorId).get();
	    doctor.setAvaliability(true);
	    doctorDetailsRepository.save(doctor);
	    LOGGER.debug("Successfully updated patient status for patient id: {}", patientId);
	    return patient;
	}


	@Override
	public boolean getPatientStatusById(int id) {
		LOGGER.debug("Getting patient status by id: {}", id);
		PatientDetails patient=patientRepository.findById(id).get();
		return patient.isStatus();
		
	}
	
}
