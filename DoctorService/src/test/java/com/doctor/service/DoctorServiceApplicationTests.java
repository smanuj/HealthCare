package com.doctor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.DoctorDetails;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.service.CommentsService;
import com.doctor.service.service.DoctorDetailsService;
import com.doctor.service.service.PatientDetailsService;

@SpringBootTest
class DoctorServiceApplicationTests {
	
	@Autowired
	private DoctorDetailsService doctorDetailsService;
	
	@Autowired
	private PatientDetailsService patientDetailsService;
	
	@Autowired
	private CommentsService commentsService;
	
	

	@Test
	void contextLoads() {
	}
	
//	@Test
//	void testGetDoctorById() {
//		DoctorDetails doctor = doctorDetailsService.getDoctorsById(1);
//		assertNotNull(doctor);
//		assertEquals(1, doctor.getDoctorId());
//		assertEquals("RITESH KUMAR SINGH", doctor.getName());
//		assertEquals("CARDIOLOGY", doctor.getSpecialization());
//	}
//
//	@Test
//	void testSaveDoctor() {
//		DoctorDetails doctor = new DoctorDetails();
//		doctor.setName("Jane Doe");
//		doctor.setSpecialization("Pediatrics");
//		doctor.setPnumber("1245");
//		doctor.setAvaliability(true);
//		doctor.setApproval(false);
//		DoctorDetails savedDoctor = doctorDetailsService.saveDoctor(doctor);
//		assertNotNull(savedDoctor);
//		assertEquals("Jane Doe", savedDoctor.getName());
//		assertEquals("1245", savedDoctor.getPnumber());
//		assertEquals("Pediatrics", savedDoctor.getSpecialization());
//		assertEquals(true, savedDoctor.isAvaliability());
//		assertEquals(false, savedDoctor.isApproval());
//	}
//	
//	@Test
//	void testGetAllDoctorsBySpecialization() {
//	    // arrange
//	    String specialization = "Cardiology";
//	    List<DoctorDetails> expectedDoctorList = Arrays.asList(
//	        new DoctorDetails(1, "John Doe", "Cardiology", "123 Main St",false,true),
//	        new DoctorDetails(2, "Jane Doe", "Cardiology", "456 Main St",false,true)
//	    );
//	    DoctorDetailsService doctorDetailsServiceMock = Mockito.mock(DoctorDetailsService.class);
//	    Mockito.when(doctorDetailsServiceMock.getAllDoctorsBySpecialization(specialization))
//	        .thenReturn(expectedDoctorList);
//
//	    // act
//	    List<DoctorDetails> actualDoctorList = doctorDetailsServiceMock.getAllDoctorsBySpecialization(specialization);
//
//	    // assert
//	    assertEquals(expectedDoctorList, actualDoctorList);
//	}
//	
//	@Test
//    void testSaveComments() {
//		PatientDetails patient= patientDetailsService.getPatientDetailsById(5);
//        Comments comment = new Comments("Test Comment",patient);
//        Comments savedComment = commentsService.createComment(comment);
//        
//        assertEquals("Test Comment", savedComment.getComments());
//    }
	
	
	
	



}
