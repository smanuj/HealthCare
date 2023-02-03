package com.login.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.service.DoctorService;
import com.login.service.service.UserService;

@SpringBootTest
class LoginServiceApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private DoctorService doctorService;

//	@Test
//	void createDoctor() throws Exception {
//		
//		
//		DoctorDetails doctor = new DoctorDetails("Divya", "9987654564", "Cardiology",true,false);
//		
//		DoctorDetails doctor1 = doctorService.saveDoctor(doctor);
//
//		UserDetails user = new UserDetails("divya@gmail.com", "divya@123", doctor1);
//
//	UserDetails user1= userService.saveUser(user);
//		UserDetails user2 = userService.getByEmail("divya@gmail.com");
//        assertEquals(user2.getDoctordetails().getName(),"Divya");	
//        assertEquals(user2.getDoctordetails().getPnumber(),"9987654564" );
//        assertEquals(user2.getDoctordetails().getSpecialization(),"Cardiology");
//        assertEquals(user2.getDoctordetails().isAvaliability(),true);
//        assertEquals(user2.getDoctordetails().isApproval(),false);
//
//	}
	
//	@Test
//	void createNurse() throws Exception {
//		NurseDetails nurse = new NurseDetails("Shreya","9986754536");
//
//		UserDetails user = new UserDetails("shreya@gmail.com", "divya@123", nurse);
//
//		String user1 = userService.saveNurse(user);
//		if(user1=="saved") {
//			System.out.println("User saved");
//		}
//		else {
//			System.out.println("User not saved");
//		}
//		
//		UserDetails user2 = userService.getByEmail("shreya@gmail.com");
//        assertEquals(user2.getNursedetails().getName(),"Shreya");	
//        assertEquals(user2.getNursedetails().getPnumber(),"9986754536" );
//        assertEquals(user2.getNursedetails().isAvaliability(),true);
//        assertEquals(user2.getNursedetails().isApproval(),false);
//
//	}

}
