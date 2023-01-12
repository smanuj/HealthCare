package com.valtech.health.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valtech.health.app.entity.Availability;
import com.valtech.health.app.repostitory.AvailabilityRepository;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	@Autowired
	private AvailabilityRepository availabilityRepository;

	/* This method creates Ambulance */
	@Override
	public Availability createAvailability(Availability a) {
		return availabilityRepository.save(a);
	}

	/* This method lists all Ambulance */
	@Override
	public List<Availability> getAllAvailability() {
		return availabilityRepository.findAll();
	}



}
