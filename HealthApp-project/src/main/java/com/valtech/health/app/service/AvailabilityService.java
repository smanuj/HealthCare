package com.valtech.health.app.service;

import java.util.List;
import com.valtech.health.app.entity.Availability;

public interface AvailabilityService {

	/* This method creates Ambulance */
	Availability createAvailability(Availability a);

	/* This method lists all Ambulance */
	List<Availability> getAllAvailability();

}