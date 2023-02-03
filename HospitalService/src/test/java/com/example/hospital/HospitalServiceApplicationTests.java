package com.example.hospital;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.hospital.entity.Hospital;
import com.example.hospital.repository.HospitalRepository;
import com.example.hospital.service.HospitalService;

@SpringBootTest
class HospitalServiceApplicationTests {

	@Autowired
	HospitalService hospitalService;
	
	@Autowired
	HospitalRepository hospitalRepository;

	
//	@Test
//	public void testcreateHospital() {
//		Hospital p1 = new Hospital("jayadeva", "JP Nagarr","560075",true);
//		Hospital saved=hospitalService.save(p1);
//		assertNotNull(saved);
//		assertEquals("jayadeva", saved.getName());
//		assertEquals("JP Nagarr", saved.getLocation());
//		assertEquals("560075", saved.getPincode());
//		assertEquals(true, saved.isBedAvailabilty() );
//	}


}
