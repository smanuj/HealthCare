package com.example.hospital.service;


import java.util.List;
import java.util.Optional;

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

	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private UserDetailsFacade userDetailsFacade;
	
	
	
	@Override
	public List<Hospital> findAll() {
		
		return hospitalRepository.findAll();
	}
	
	@Override
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	@Override
	public Hospital findHospitalById(int id) throws ResourceNotFoundException  {
		 Optional<Hospital> h = hospitalRepository.findById(id);
		    if(h.isPresent()) {
		      return h.get();
		    }else
		    {
		      throw new ResourceNotFoundException("Not found");
		    }
	}
	
	@Override
	public Hospital updateHospital(Hospital h, int id) {
		
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
		    return hospital;
		    
	}
	
	@Override
	public void deleteHospital(int id) {
		 hospitalRepository.deleteById(id);
	}

	@Override
	public List<String> findHospitalNames() {
		return hospitalRepository.findHospitalNames();
	}
	
	@Override
	public List<DoctorDetails> getDoctorList(){
		return userDetailsFacade.getDoctors();
	}

	
	
	public ResponseEntity<DoctorDetails> approvingDoctor(int id) {
		DoctorDetails doctor = userDetailsFacade.getDoctorById(id);
		doctor.setApproval(true);
		return userDetailsFacade.saveDoctor(doctor);
	}
	
	
	@Override
	public List<NurseDetails> getNurseList(){
		return userDetailsFacade.getNurses();
	}


	
	public ResponseEntity<NurseDetails> approvingNurse(int id) {
		NurseDetails nurse = userDetailsFacade.getNurseById(id);
		nurse.setApproval(true);
		return userDetailsFacade.saveNurse(nurse);
	}
	
	public String deleteDoctor(int id) {
		userDetailsFacade.doctorDisapprove(id);
		return "Disapproved";
	}
	
	public String deleteNurse(int id) {
		userDetailsFacade.nurseDisapprove(id);
		return "Disapproved";
	}
	
	

}
