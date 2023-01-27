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
import com.example.hospital.repository.HospitalRepository;

import com.example.hospital.facade.UserDetailsFacade;


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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		 Hospital hospital = hospitalRepository.findById(id).get();
		    if(hospital.getHospitalId()!=0) {
		      hospital.setName(h.getName());
		      hospital.setLocation(h.getLocation());
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
		// TODO Auto-generated method stub
		 hospitalRepository.deleteById(id);
	}

	@Override
	public List<String> findHospitalNames() {
		// TODO Auto-generated method stub
		return hospitalRepository.findHospitalNames();
	}
	
	@Override
	public List<DoctorDetails> getDoctorList(){
		System.out.println(userDetailsFacade.getdoctors());
		return userDetailsFacade.getdoctors();
	}

	
	
	public ResponseEntity<DoctorDetails> approvingDoctor(int id) {
		DoctorDetails doctor = userDetailsFacade.getdoctorbyid(id);
		doctor.setApproval(true);
		return userDetailsFacade.savedoctor(doctor);
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
	
	public String deletedoctor(int id) {
		userDetailsFacade.doctordisapprove(id);
		return "Disapproved";
	}
	
	public String deleteNurse(int id) {
		userDetailsFacade.nursedisapprove(id);
		return "Disapproved";
	}

}
