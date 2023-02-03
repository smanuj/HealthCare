package com.login.service.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.DoctorRepository;

import com.login.service.repo.NurseRepository;
import com.login.service.repo.UserRepository;
import com.login.service.service.DoctorService;
import com.login.service.service.NurseService;
import com.login.service.service.UserService;
import com.login.service.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private NurseService nurseService;

	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping("/users")
	public List<UserDetails> getAllUsers() {
		logger.info("Fetching all user details");
		return userService.getalluser();
	}

	@PostMapping("/savedoctor")
	public String saveUserDoctorDetail(@RequestBody UserDetails user) throws Exception {
		logger.info("Creating new Doctor details");
		String savedoctor = userService.saveDoctor(user);
		logger.debug("Saved doctor details", savedoctor);
		return savedoctor;

	}

	@PostMapping("/doctor")
	public DoctorDetails saveDoctorDetail(@RequestBody DoctorDetails doctor1) {
		DoctorDetails doctor = doctorRepository.save(doctor1);
		logger.debug("Saved doctor details", doctor);
		return doctor;

	}

	@PutMapping("/doctor")
	public DoctorDetails updateDoctorDetail(@RequestBody DoctorDetails doctor1) {
		logger.info("Updating doctor  details");
		DoctorDetails doctor = doctorRepository.save(doctor1);
		logger.debug("Updated doctor details", doctor);
		return doctor;

	}

	@PostMapping("/savenurse")
	public String saveUserNurseDetail(@RequestBody UserDetails user) throws Exception {
		logger.info("Creating new Nurse details");
		String savenurse = userService.saveNurse(user);
		logger.debug("Saved Nurse details", savenurse);
		return savenurse;

	}

	@PostMapping("/login")
	public String userLogin(@RequestBody UserDetails user) throws Exception {
		logger.info("Checking email and password is registered or not");
		String loginuser = userService.loginUser(user);
		return loginuser;
	}

	@GetMapping("/doctorlogin/{email}")
	public int doctorLogin(@PathVariable("email") String email) {
		logger.info("Fetching id of the doctor");
		int loginuser = userService.doctorlogin(email);
		return loginuser;
	}

	@GetMapping("/nurselogin/{email}")
	public int nurseLogin(@PathVariable("email") String email) {
		logger.info("Fetching id of the nurse");
		int loginuser = userService.nurselogin(email);
		return loginuser;
	}

	@GetMapping("/doctors")
	public List<DoctorDetails> getAllDoctors() {
		logger.info("Fetching add doctor details");
		return doctorRepository.findAll();
	}

	@GetMapping("/hospitals")
	public List<Hospital> getAllHospital() {
		logger.info("Fetching all hospital details");
		return doctorService.getHospitalList();
	}

	@GetMapping("/hospitals/{id}")
	public Hospital getAllHospitalById(@PathVariable("id") int hospitalId) {
		logger.info("Fetching hospital detail by id");
		return userService.getById(hospitalId);
	}

	@GetMapping("/nurse")
	public List<NurseDetails> getNurseDetailsApprovalFalse() {
		logger.info("List of nurse details where approval is false");
		return nurseService.getByapprovefalse();
	}

	@GetMapping("/doctor")
	public List<DoctorDetails> getDoctorDetailsApprovalFalse() {
		logger.info("List of doctor details where approval is false");
		return doctorService.getByapprovefalse();
	}

	@GetMapping("/user/{id}")
	public UserDetails findById(@PathVariable("id") int id) {
		logger.info("Fecthing user details by id");
		return userService.findById(id);
	}
	
	

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int userId) {
		logger.info("Deleting user details by id");
		userService.deletUser(userId);
	}

	@DeleteMapping("/nurse/{id}")
	public void deleteNurse(@PathVariable("id") int id) {
		logger.info("Deleting nurse details by id");
		nurseService.deleteNurse(id);
	}

	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable("id") int id) {
		logger.info("Deleting doctor details by id");
		doctorService.deleteDoctor(id);
	}

	@GetMapping("/doctor/{id}")
	public Optional<DoctorDetails> getDoctorById(@PathVariable("id") int id) {
		logger.info("Fetching doctor detail by id");
		return doctorService.doctorgetdoctorbyid(id);
	}

	@GetMapping("/doctorApproval")
	public List<DoctorDetails> doctor() {
		List<DoctorDetails> user = doctorService.getByapprovefalse();
		return user;
	}

	@PostMapping("/doctorApproval/{id}")
	public String doctorApproval(@PathVariable("id") int id) {
		logger.info("Updating doctor approve as true");
		doctorService.approvingDoctor(id);
		return "Approved";
	}

	@DeleteMapping("/doctorDisapproval/{id}")
	public void doctorDisapproval(@PathVariable("id") int id) {
		logger.info("Deleting doctor detail ,if admin disapprove");
		doctorService.deleteDoctor(id);

	}

	@GetMapping("/nurseApproval")
	public List<NurseDetails> getNurseDetailApproveFalse() {
		List<NurseDetails> user = nurseService.getByapprovefalse();
		return user;
	}

	@PostMapping("/api/nurse")
	public NurseDetails updateNurse(@RequestBody NurseDetails nurse) {
		logger.info("Updating nurse details");
		return nurseService.saveNurse(nurse);

	}

	@GetMapping("/nurse/{id}")
	public Optional<NurseDetails> getNurseById(@PathVariable("id") int id) {
		logger.info("Fetching nurse details by id");
		return nurseService.getNurseById(id);
	}

	@PostMapping("/nurseApproval/{id}")
	public String nurseApproval(@PathVariable("id") int id) {
		logger.info("Updating nurse approve as true");
		nurseService.approvingNurse(id);
		return "Approved";
	}

	@DeleteMapping("/nurseDisapproval/{id}")
	public void nurseDisapproval(@PathVariable("id") int id) {
		logger.info("Deleting nurse detail ,if admin disapprove");
		nurseService.deleteNurse(id);

	}

	@GetMapping("/getrole/{user}")
	public String getRole(@PathVariable("user")UserDetails user) {
		logger.info("Getting role of the user");
		String s1= userService.getRole(user);
		System.out.println(s1);
		return s1;
	}

	@GetMapping("/{id}/{password}")
	public boolean checkPassword(@PathVariable("id") int id, @PathVariable("password") String password) {
		return userService.checkPassword(id, password);
	}

	@PostMapping("/{id}/{password}")
	public void changePassword(@PathVariable("id") int id, @PathVariable("password") String password) {
		userService.changePassword(id, password);
	}

	@GetMapping("/{email}")
	public UserDetails getByEmail(@PathVariable("email") String email) {
		return userService.getByEmail(email);
	}

	@PostMapping("/saveuser")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {
		return userService.saveUser(userDetails);
	}
	
	@PostMapping("/userdetailsbydoctor")
	public UserDetails  getdoctordetailsbyuser(@RequestBody DoctorDetails doctor) {
		return userService.getbydoctordetails(doctor);
	}
	
	@PostMapping("/userdetailsbynurse")
	public UserDetails  getnursedetailsbyuser(@RequestBody NurseDetails nurse) {
		return userService.getbyNursedetails(nurse);
	}
	
	

}
