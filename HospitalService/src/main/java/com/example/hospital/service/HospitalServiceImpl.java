package com.example.hospital.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.DoctorDetails;
import com.example.hospital.entity.Hospital;
import com.example.hospital.entity.NurseDetails;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.facade.UserDetailsFacade;
import com.example.hospital.repository.HospitalRepository;


@Service
public class HospitalServiceImpl implements HospitalService {

	private static final Logger logger = LoggerFactory.getLogger(HospitalServiceImpl.class);
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private UserDetailsFacade userDetailsFacade;
	
	
	
	@Override
	public List<Hospital> findAll() {
		logger.info("Fetching all hospital details");
		return hospitalRepository.findAll();
	}
	
	@Override
	public Hospital save(Hospital hospital) {
		logger.info("Creating new hospital");
		logger.debug("creating new hospital", hospital);
		return hospitalRepository.save(hospital);
	}
	
	@Override
	public Hospital findHospitalById(int id) throws ResourceNotFoundException  {
		 logger.info("Fetching hospital detail by id");
		 Optional<Hospital> h = hospitalRepository.findById(id);
		 logger.debug("Fetching the hospital with id", id);
		    if(h.isPresent()) {
		      return h.get();
		    }else
		    {
		      throw new ResourceNotFoundException("Not found");
		    }
	}
	
	@Override
	public Hospital updateHospital(Hospital h, int id) {
		 logger.info("Updating hospital detail");
		 Hospital hospital = hospitalRepository.findById(id).get();
		    if(hospital.getHospitalId()!=0) {
				
				  hospital.setName(h.getName()); hospital.setLocation(h.getLocation());
				  hospital.setPincode(h.getPincode());
				  hospital.setBedAvailabilty(h.isBedAvailabilty());
				 
		    }
		    else
		    {
		      throw new ResourceNotFoundException("Not found");
		    }
		    hospitalRepository.save(hospital);
		    logger.debug("Updating the hospital with id", id);
		    return hospital;
		    
	}
	
	@Override
	public void deleteHospital(int id) {
		 logger.info("Deleting the hospital detail by id");
		 logger.debug("Deleting the hospital with id", id);
		 hospitalRepository.deleteById(id);
	}

	@Override
	public List<String> findHospitalNames() {
		logger.info("fetching all the hospital names");
		return hospitalRepository.findHospitalNames();
	}
	
	@Override
	public List<DoctorDetails> getDoctorList(){
		logger.info("List of doctor details where approval is false");
		return userDetailsFacade.getDoctors();
	}

	
	
	public ResponseEntity<DoctorDetails> approvingDoctor(int id) {
		DoctorDetails doctor = userDetailsFacade.getDoctorById(id);
		logger.info("Updating doctor approval as true");
		doctor.setApproval(true);
		logger.debug("Updating the doctor approval with id to true", id);
		return userDetailsFacade.saveDoctor(doctor);
	}
	
	
	@Override
	public List<NurseDetails> getNurseList(){
		logger.info("List of nurse details where approval is false");
		return userDetailsFacade.getNurses();
	}

	public ResponseEntity<NurseDetails> approvingNurse(int id) {
		logger.info("Updating nurse approval as true");
		NurseDetails nurse = userDetailsFacade.getNurseById(id);
		nurse.setApproval(true);
		logger.debug("Updating the nurse approval with id to true", id);
		return userDetailsFacade.saveNurse(nurse);
	}
	
	public String deleteDoctor(int id) {
		logger.info("Disapproving the doctor and deleting the doctor detail");
		userDetailsFacade.doctorDisapprove(id);
		logger.debug("Deleting the doctor and set approval with id to false", id);
		return "Disapproved";
	}
	
	public String deleteNurse(int id) {
		logger.info("Disapproving the nurse and deleting the doctor detail");
		userDetailsFacade.nurseDisapprove(id);
		logger.debug("Deleting the nurse and set approval with id to false", id);
		return "Disapproved";
	}

	@Override
	public List<Hospital> getHospitalsByPincode(String pincode) {
		// TODO Auto-generated method stub
		return hospitalRepository.findByPincode(pincode);
	}



	

}
