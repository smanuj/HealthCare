package com.login.service.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
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

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private NurseService nurseService;

	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping("/api/users")
	public List<UserDetails> getAllUsers() {
		return userService.getalluser();
	}

	@PostMapping("/api/savedoctor")
	public String saveUserDoctorDetail(@RequestBody UserDetails user) throws Exception {
		String savedoctor = userService.saveDoctor(user);
		return savedoctor;

	}

	@PostMapping("/api/doctor")
	public DoctorDetails saveDoctorDetail(@RequestBody DoctorDetails doctor1) {
		return doctorRepository.save(doctor1);

	}

	@PutMapping("/api/doctor")
	public DoctorDetails updateDoctorDetail(@RequestBody DoctorDetails doctor1) {
		return doctorRepository.save(doctor1);

	}

	@PostMapping("/api/savenurse")
	public String saveUserNurseDetail(@RequestBody UserDetails user)throws Exception {
		String savenurse = userService.saveNurse(user);
		return savenurse;

	}

	@PostMapping("/api/login")
	public String userLogin(@RequestBody UserDetails user) throws Exception {
		String loginuser = userService.loginUser(user);
		return loginuser;
	}

	@GetMapping("/doctors")
	public List<DoctorDetails> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@GetMapping("/hospitals")
	public List<Hospital> getAllHospital() {
		return doctorService.getHospitalList();
	}

	@GetMapping("/hospitals/{id}")
	public Hospital getAllHospitalById(@PathVariable("id") int hospitalId) {

		return userService.getById(hospitalId);
	}

	@GetMapping("/nurse")
	public List<NurseDetails> getNurseDetailsApprovalFalse() {
		return nurseService.getByapprovefalse();
	}

	@GetMapping("/doctor")
	public List<DoctorDetails> getDoctorDetailsApprovalFalse() {
		return doctorService.getByapprovefalse();
	}

	@GetMapping("/user/{id}")
	public UserDetails findById(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int userId) {
		userService.deletUser(userId);
	}

	@DeleteMapping("/nurse/{id}")
	public void deleteNurse(@PathVariable("id") int id) {
		nurseService.deleteNurse(id);
	}

	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable("id") int id) {
		doctorService.deleteDoctor(id);
	}

	@GetMapping("/doctor/{id}")
	public Optional<DoctorDetails> getDoctorById(@PathVariable("id") int id) {
		return doctorService.doctorgetdoctorbyid(id);
	}

	@GetMapping("/doctorApproval")
	public List<DoctorDetails> doctor() {
		List<DoctorDetails> user = doctorService.getByapprovefalse();
		return user;
	}

	@PostMapping("/doctorApproval/{id}")
	public String doctorApproval(@PathVariable("id") int id) {
		doctorService.approvingDoctor(id);
		return "Approved";
	}

	@DeleteMapping("/doctorDisapproval/{id}")
	public void doctorDisapproval(@PathVariable("id") int id) {
		doctorService.deleteDoctor(id);


	}

	@GetMapping("/nurseApproval")
	public List<NurseDetails> getNurseDetailApproveFalse() {
		List<NurseDetails> user = nurseService.getByapprovefalse();
		return user;
	}

	@PostMapping("/api/nurse")
	public NurseDetails updateNurse(@RequestBody NurseDetails nurse) {
		return nurseService.saveNurse(nurse);

	}

	@GetMapping("/nurse/{id}")
	public Optional<NurseDetails> getNurseById(@PathVariable("id") int id) {
		return nurseService.getNurseById(id);
	}

	@PostMapping("/nurseApproval/{id}")
	public String nurseApproval(@PathVariable("id") int id) {
		nurseService.approvingNurse(id);
		return "Approved";
	}

	@DeleteMapping("/nurseDisapproval/{id}")
	public void nurseDisapproval(@PathVariable("id") int id) {
		nurseService.deleteNurse(id);

	}

	@GetMapping("/getrole")
	public String getRole(UserDetails user) {
		return userService.getRole(user);
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

}
