package com.example.hospital.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.entity.Hospital;
import com.example.hospital.repository.HospitalRepository;
import com.example.hospital.exception.ResourceNotFoundException;

@Service
public class HospitalServiceImpl implements HospitalService {

	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public List<Hospital> findAll() {
		// TODO Auto-generated method stub
		
		return hospitalRepository.findAll();
	}
	
	@Override
	public Hospital save(Hospital hospital) {
		// TODO Auto-generated method stub
		System.out.println(hospital.getBedavailability());
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
		    if(hospital.getId()!=0) {
		      hospital.setName(h.getName());
		      hospital.setNumber(h.getNumber());
		      hospital.setLocation(h.getLocation());
		      hospital.setPincode(h.getPincode());
		      hospital.setBedavailability(h.getBedavailability());
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

	}
