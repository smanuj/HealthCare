package com.valtech.health.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.health.app.entity.Doctor;
import com.valtech.health.app.entity.Hospital;
import com.valtech.health.app.entity.User;
import com.valtech.health.app.repostitory.DoctorRepository;
import com.valtech.health.app.repostitory.HospitalRepository;
import com.valtech.health.app.repostitory.PatientDetailsRepository;
import com.valtech.health.app.repostitory.UserRepository;
import com.valtech.health.app.service.DoctorService;
import com.valtech.health.app.service.HospitalService;
import com.valtech.health.app.service.PatientDetailsService;
import com.valtech.health.app.service.UserService;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class HealthAppApplicationTests {
	@Autowired
	private MockMvc mvc;

	/* Testing for about us page */
	@Test
	@WithAnonymousUser
	void testAboutUsWithAnonymous() throws Exception {
		mvc.perform(get("/aboutus")).andExpect(status().isOk());
	}

	/* Testing for home page */
	@Test
	@WithAnonymousUser
	void testHomeWithAnonymous() throws Exception {
		mvc.perform(get("/home")).andExpect(status().isOk());
	}

	/* Testing for login page */
	@Test
	@WithAnonymousUser
	void testLoginWithAnonymous() throws Exception {
		mvc.perform(get("/login")).andExpect(status().isOk());
	}

	/* Testing for register page */
	@Test
	@WithAnonymousUser
	void testRegisterWithAnonymous() throws Exception {
		mvc.perform(get("/register")).andExpect(status().isOk());
	}

	/* Testing for patient details page */
	@Test
	@WithAnonymousUser
	void testPatientDetailsWithAnonymous() throws Exception {
		mvc.perform(get("/patientdetails")).andExpect(status().isOk());
	}

	/* Testing for doctor page */
	@Test
	@WithAnonymousUser
	void testDoctorsWithAnonymous() throws Exception {
		mvc.perform(get("/doctor")).andExpect(status().isOk());
	}

	/* Testing for doctor list page */
	@Test
	@WithAnonymousUser
	void testDoctorListWithAnonymous() throws Exception {
		mvc.perform(get("/doctorlist")).andExpect(status().isOk());
	}

	/* Testing for doctor's comment page */
	@Test
	@WithAnonymousUser
	void testCommentList() throws Exception {
		mvc.perform(get("/commentlist")).andExpect(status().isOk());
	}

	/* Testing for admin dashboard page */
	@Test
	@WithAnonymousUser
	void testAdminDashboardWithAnonymous() throws Exception {
		mvc.perform(get("/admindashboard")).andExpect(status().isOk());
	}

	/* Testing for admin home page */
	@Test
	@WithAnonymousUser
	void testAdminWithAnonymous() throws Exception {
		mvc.perform(get("/admin")).andExpect(status().isOk());
	}

	// Testing whether the otp is working correctly
	@Test
	@WithAnonymousUser
	void testSendOtpAnonymous() throws Exception {
		mvc.perform(get("/sendotp")).andExpect(status().isOk());
	}

	@Test
	@WithAnonymousUser
	void testForgotPasswordAnonymous() throws Exception {
		mvc.perform(get("/forgotpassword")).andExpect(status().isOk());
	}

	/* Testing for ambulance list page */
	@Test
	@WithAnonymousUser
	void testAvailabilityListWithAnonymous() throws Exception {
		mvc.perform(get("/adminlist")).andExpect(status().isOk());
	}

	/* Testing for hospital list page */
	@Test
	@WithAnonymousUser
	void testHospitalListWithAnonymous() throws Exception {
		mvc.perform(get("/hospitallist")).andExpect(status().isOk());
	}

	/* Testing for hospital home page */
	@Test
	@WithAnonymousUser
	void testHospitalWithAnonymous() throws Exception {
		mvc.perform(get("/hospital")).andExpect(status().isOk());
	}

	@MockBean
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorService doctorService;

	@MockBean
	private HospitalRepository hospitalRepository;

	@Autowired
	private HospitalService hospitalService;

	/* Testing for finding all doctor comment */
	@Test
	public void getComments() {
		when(doctorRepository.findAll())
				.thenReturn(Stream.of(new Doctor("heena", "aaa", "sick")).collect(Collectors.toList()));
		assertEquals(1, doctorService.getAllDoctorComments().size());
	}

	@Test
	public void getAllDoctorsComments() {

		when(doctorRepository.findAll())
				.thenReturn(Stream.of(new Doctor("heena", "ameena", "sick")).collect(Collectors.toList()));
		assertEquals(1, doctorService.getAllDoctorComments().size());
	}

	@Test
	public void savedoctorsComments() {
		Doctor d = new Doctor("heena", "ameena", "sick");
		when(doctorRepository.save(d)).thenReturn(d);
		assertEquals(d, doctorService.createDoctor(d));

	}

	@Test
	public void createDoctor() {
		Doctor d = new Doctor("heena", "ameena", "sick");
		when(doctorRepository.save(d)).thenReturn(d);
		assertEquals(d, doctorService.createDoctor(d));
	}

	
	

	/* test cases for patientDetaiilsServiceImpl */

	@Autowired
	PatientDetailsService patientDetailsService;
	@MockBean
	private PatientDetailsRepository patientDetailsRepository;

	

	/* Test cases for userServiceImpl */

	@Autowired
	UserService userService;
	@MockBean
	UserRepository userRepository;

	/* Testing for creating nurse */
	@Test
	public void createUser() {
		User u = new User("heena", "123", "heena@gmail.com", "hina", "abc", "gfk", 12);
		when(userRepository.save(u)).thenReturn(u);
		assertEquals(u, userService.createUser(u));
	}

	/* Testing for creating hospital */
	@Test
	public void createHospital() {

		Hospital p1 = new Hospital("jayadev", "9876543210");
		when(hospitalRepository.save(p1)).thenReturn(p1);
		assertEquals(p1, hospitalService.createHospital(p1));

	}

}
