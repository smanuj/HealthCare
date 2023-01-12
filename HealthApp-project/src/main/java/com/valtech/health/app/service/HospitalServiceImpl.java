package com.valtech.health.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.valtech.health.app.entity.Hospital;
import com.valtech.health.app.repostitory.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;

	/* This method creates Hospital */
	@Override
	public Hospital createHospital(Hospital h) {
		return hospitalRepository.save(h);
	}

	/* This method lists all Hospitals */
	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	/* This method updates Hospital Details */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Hospital updateHospitalDetails(Hospital h) {
		// TODO Auto-generated method stub
		return hospitalRepository.save(h);
	}

	/* This method retrieves Hospitals by ID */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Hospital getHospitalById(int id) {
		// TODO Auto-generated method stub
		return hospitalRepository.getReferenceById(id);
	}
	
	 @Override
	    public void deleteHospitalById(int id)
	    {
		 hospitalRepository.deleteById(id);
	    }


	 /* This method finds hospital by hospital name */
		@Override
		public Hospital findByHospitalname(String hospitalName) {
			return hospitalRepository.findByHospitalname(hospitalName);
		}

}
