package com.valtech.health.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.health.app.entity.Availability;
import com.valtech.health.app.entity.Doctor;
import com.valtech.health.app.entity.Hospital;
import com.valtech.health.app.entity.PatientDetails;
import com.valtech.health.app.entity.User;
import com.valtech.health.app.model.PatientDetailsModel;
import com.valtech.health.app.model.UserModel;
import com.valtech.health.app.service.AvailabilityService;
import com.valtech.health.app.service.DoctorService;
import com.valtech.health.app.service.EmailService;
import com.valtech.health.app.service.HospitalService;
import com.valtech.health.app.service.PatientDetailsService;
import com.valtech.health.app.service.UserService;

@Controller
public class HealthAppController {

	@Autowired
	private UserService userService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AvailabilityService availabilityService;
	@Autowired
	private PatientDetailsService patientService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private EmailService emailService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	private final Logger logger = LoggerFactory.getLogger(HealthAppController.class);

	/* About Us */
	@GetMapping("/aboutus")
	public String aboutUS() {
		logger.info("moving to about us page");
		return "aboutus";
	}

	/* This method creates Admin DashBoard */
	@GetMapping("/admindashboard")
	public String createnewadmin() {
		logger.info("login to admin dashboard");
		return "admindashboard";
	}

	/* This method helps us to check availability of hospital and doctors */
	@GetMapping("/admin")
	public String newambulance(Model m) {
		logger.info("admin has logged checking for availability");
		List<Hospital> ha = hospitalService.getAllHospitals();
		m.addAttribute("ha", ha);
		logger.debug("updated successful " + ha);
		return "admin";
	}

	/* This method helps us to check availability of hospital and doctors */
	@PostMapping("/admin")
	public String ambulance(@ModelAttribute Availability a, Model model,
			@RequestParam("hospitalName") String hospitalName) {
		logger.info("admin created availability");
		
		Hospital h = hospitalService.findByHospitalname(hospitalName);
		a.setHospital(h);
		availabilityService.createAvailability(a);
		if ((a.getDoctorsAvailability().equals("Yes")) && (a.getBedAvailability().equals("Yes"))) {
			try {
				model.addAttribute("success", "Succesfully Updated");

				logger.debug("both doctor and bed are available " + a + "" + hospitalName);
			} catch (Exception e) {
				logger.error("doctor and bed are not available");
				e.printStackTrace();
				// model.addAttribute("error", e);
			}
			return "admin";
		} else {
			try {
				model.addAttribute("error", "No Availability");
				logger.error("Not Available " + a + "" + hospitalName);
			} catch (Exception e1) {
				e1.printStackTrace();
				// model.addAttribute("error", e1);
			}
			return "admin";
		}
	}

	/* To add hospital */
	@GetMapping("/hospital")
	public String newhospital() {
		logger.info("get hospital details");
		return "hospital";
	}

	/* To add hospital */
	@PostMapping("/hospital")
	public void hospital(@ModelAttribute Hospital h, Model model) {
		try {
			logger.info("to add hospital details");
			hospitalService.createHospital(h);
			model.addAttribute("success", "Successfully Sent");
			logger.debug("hospital details added " + h);
		} catch (Exception e) {
			e.printStackTrace();
			// model.addAttribute("error", e);
		}
	}

	/* This method lists the hospitals */
	@GetMapping("/hospitallist")
	public String hospitallist(Model model) {
		logger.info("to get details");
		model.addAttribute("h", hospitalService.getAllHospitals());
		logger.debug("hospital details added " + hospitalService.getAllHospitals());
		return "hospitallist";
	}

	/* This method lists the availability */
	@GetMapping("/adminlist")
	public String Commentsambulance(Model model) {
		logger.info(" getting admin details");
		model.addAttribute("am", availabilityService.getAllAvailability());
		logger.debug("admin details added " + availabilityService.getAllAvailability());
		return "adminlist";
	}

	/* This method updates the hospital */
	@PostMapping("/updatehospitals/{id}")
	public ModelAndView saveUpdateHospitalDetails(@PathVariable("id") int id, @ModelAttribute Hospital h,
			@RequestParam("submit") String submit, Model model) {
		logger.info("update hospital details");
		ModelAndView view = new ModelAndView("/hospitallist");
		if (submit.equals("Cancel")) {
			logger.info("no details are updated");
			view.addObject("h", hospitalService.getAllHospitals());
			logger.debug("cancelled " + h);
			return view;
		}
		hospitalService.updateHospitalDetails(h);
		view.addObject("h", hospitalService.getAllHospitals());
		logger.debug("updated hospital details " + h);
		return view;
	}

	/* This method updates the hospital */
	@GetMapping("/updatehospitals/{id}")
	public String updateHospitalDetails(@PathVariable("id") int id, Model model) {
		logger.info("update for hospital");
		model.addAttribute("h", hospitalService.getHospitalById(id));
		logger.debug("updated for hospital " + id);
		return "updatehospital";
	}

	/* This method displays the nurse home page */
	@GetMapping("/home")
	public String home() {
		logger.info("redirects to Home");
		return "home";
	}

	@PostMapping("/login")
	public String LoginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, @ModelAttribute UserModel userModel) {
		String url;
		User u = null;

		if (userModel.getUsername().equals("admin") && userModel.getPassword().equals("admin")) {
			logger.info("login into admin");
			logger.debug("login successfull");
			return "admindashboard";
		}

		try {
			u = userService.findByUsername(userModel.getUsername());
			if (u != null && bCryptPasswordEncoder.matches(password, u.getPassword())) {
				logger.debug("print user " + username);
				System.out.println(u);
				if (u.getRole().equals("NURSE")) {
					logger.info("redirect to nurse dashboard");
					logger.debug("NURSE username is  " + username);
					System.out.println(u);
					model.addAttribute("username", username);
					int id = userService.getIdbyUsername((userModel.getUsername()));
					url = "redirect:/dashboard/" + id;
					return url;
				} else if (u.getRole().equals("DOCTOR")) {
					logger.info("redirect to doctor dashboard");
					logger.debug("DOCTOR username is " + username);
					System.out.println(u);
					model.addAttribute("username", username);
					int id = userService.getIdbyUsername((userModel.getUsername()));
					url = "redirect:/doctordashboard/" + id;

					return url;
				}

			}
		} catch (Exception e) {

			System.out.println();
			model.addAttribute("error", "Entered username or password are not correct");
			logger.error("details provided are incorrect");
			return "login";
		}

		model.addAttribute("error", "Entered username or password are not correct");
		return "login";
	}

	/* Login Page */
	@GetMapping("/login")
	public String login() {
		logger.info("moving to login page");
		return "login";
	}

	/* Register Page */
	@PostMapping("/register")
	public String registerUser(@RequestParam("email") String email, @Valid @ModelAttribute User u,
			@ModelAttribute UserModel userModel, Model model, BindingResult result) {
		logger.info("moving to register page");
		User u1 = null;
		try {

			u1 = userService.findByEmail(email);
		} catch (Exception e) {
			logger.error("user already exists");
			System.out.println("User already registered !!!");
		}
		if (u1 != null) {
			logger.info("It will reject");
			model.addAttribute("error", "User Already Registered");
			return "register";
		}

		if (userModel.getPassword().equals(userModel.getConfirmpassword())) {

			userService.createUser(u);
			return "login";
		} else {
			model.addAttribute("error", "Password and Confirm Password doesnot match");
			return "register";
		}
	}

	/* Register Page */
	@GetMapping("/register")
	public String register(@ModelAttribute User u) {
		logger.info("moving to register page");
		logger.debug("Successfully moved to register page with user " + u);
		return "register";
	}

	/* Dash-Board For Nurse */
	@GetMapping("/dashboard/{id}")
	public String createnew1(@PathVariable("id") int id, ModelMap model) {
		logger.info("Moving to nurse dashboard");
		User u = userService.getUsername(id);

		model.addAttribute("add", u.getName());
		logger.debug("Moved to nurse dashboard with nurse " + u + " and id " + id);
		return "dashboard";
	}

	/* This method helps to send patient details */
	@GetMapping("/patientdetails")
	public String newpatientdetails(Model m, @ModelAttribute User u) {
		try {
			logger.info("Moving to patientdetails");
			List<User> da = userService.getAllUsers();
			List<User> daa = new ArrayList<>();

			for (User user : da) {
				if (user.getRole().equals("DOCTOR")) {
					daa.add(user);
				}
			}

			m.addAttribute("daa", daa);
			logger.debug("Moved to patient details " + u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return "patientdetails";
	}

	/* This method helps to send patient details */
	@PostMapping("/patientdetails")
	public String patientdetails(@ModelAttribute PatientDetailsModel p, @ModelAttribute PatientDetails pd,
			ModelAndView model, Model m, @RequestParam("doctorsname") String doctorsname) {
		try {
			logger.info("Adding patientdetails");

			String to = userService.getEmailByName(p.getDoctorsname());
			String subject = "It's an emergency doctor!!";
			String text = "Please access the website";
			emailService.SendMail(to, subject, text);
			m.addAttribute("name", p.getName());
			User u = userService.findByName(doctorsname);
			pd.setUsers(u);
			patientService.createPatientDetails(pd);
			m.addAttribute("success", "Successfully Sent");
			logger.debug("Successfully added " + pd);
		} catch (Exception e) {
			System.out.println(e);

		}
		return "patientdetails";
	}

	/* This method helps to list the patient details */
	@GetMapping("/list/{id}")
	public String list(Model model,@PathVariable("id") int id) {
		logger.info("Display patientdetails");
		List<PatientDetails> pd = patientService.getAllPatientDetails();
		List<PatientDetails> pds = new ArrayList<>();
		for (PatientDetails patientDetails : pd) {
			if (patientDetails.getUsers().getId()==id) {
				pds.add(patientDetails);
			}
		}
		System.out.println(pds);
		model.addAttribute("p", pds);
		logger.debug("Successfully displayed patientdetails " + patientService.getAllPatientDetails());
		return "list";
	}

	/* This method helps to update the patient details */
	@PostMapping("/updatePatientDetails/{id}")
	public ModelAndView saveUpdatePatientDetails(@PathVariable("id") int id, @ModelAttribute PatientDetails p,
			@RequestParam("submit") String submit) {
		logger.info("Updating the patient details");
		ModelAndView view = new ModelAndView("/list");
		if (submit.equals("Cancel")) {
			view.addObject("p", patientService.getAllPatientDetails());
			return view;
		}
		patientService.updatePatientsDetails(p);
		view.addObject("p", patientService.getAllPatientDetails());
		logger.debug("Successfully updated patientdetails" + p);
		return view;
	}

	/* This method helps to update the patient details */
	@GetMapping("/updatePatientDetails/{id}")
	public String updatePatientsDetails(@PathVariable("id") int id, Model model) {
		logger.info("It will display the updated patientdetails");
		model.addAttribute("p", patientService.getPatientById(id));
		logger.debug("Successfully displayed updatedpatientdetails " + patientService.getPatientById(id));
		return "updatePatientDetails";
	}

	/* Dash-Board For Doctor */
	@GetMapping("/doctordashboard/{id}")
	public String createnew(@PathVariable("id") int id, ModelMap model) {
		logger.info("Welcome page for doctor");
		User du = userService.getUsername(id);
		model.addAttribute("add", du.getName());
		model.addAttribute("docid", du.getId());
		logger.debug("Displayed welcome page for doctor " + du);
		return "doctordashboard";
	}

	/* This method helps to send doctor comments */
	@GetMapping("/doctor")
	public String newdoctordetails(Model m) {
		List<User> ad = userService.getAllUsers();
		List<User> daa = new ArrayList<>();
		for (User user : ad) {
			if (user.getRole().equals("NURSE")) {
				daa.add(user);
			}
		}
		m.addAttribute("ad", daa);
		return "doctor";
	}

	/* This method helps to send doctor comments */
	@PostMapping("/doctor")
	public String doctorPatientdetails(@ModelAttribute Doctor d, Model m) {
		try {
			logger.info("Sending comment by doctor");

			String to = userService.getEmailByName(d.getNursename());
			String subject = "Doctor has been commented";
			String text = "Please access the website";
			emailService.SendMail(to, subject, text);
			m.addAttribute("name", d.getNursename());
			doctorService.createDoctor(d);
			m.addAttribute("success", "Successfully Sent");
			logger.debug("Successfully commented by doctor " + d);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "doctor";
	}

	/* This method helps to list the doctor comments */
	@GetMapping("/doctorlist")
	public String doctorList(Model model) {

		model.addAttribute("d", doctorService.getAllDoctorComments());
		logger.debug("comment is " + doctorService.getAllDoctorComments());
		return "doctorlist";
	}
	
	@PostMapping("/updateDoctorComments/{id}")
    public ModelAndView saveUpdateDoctorComments(@PathVariable("id") int id, @ModelAttribute Doctor d,
            @RequestParam("submit") String submit,Model m) throws Exception {
        logger.info("It will update the doctor comments");
        ModelAndView view = new ModelAndView("/doctorlist");
        if (submit.equals("Cancel")) {
            view.addObject("d", doctorService.getAllDoctorComments());
            return view;
        }
        doctorService.updateDoctorComments(d.getDoctor_comments(), id);
        view.addObject("d", doctorService.getAllDoctorComments());
        logger.info("Successfully updated the doctor comments");
        return view;

    }

	/*@PostMapping("/updateDoctorComments/{id}")
	public ModelAndView saveUpdateDoctorComments(@PathVariable("id") int id, @ModelAttribute Doctor d,
			@RequestParam("submit") String submit, Model m) throws Exception {
		logger.info("It will update the doctor comments");
		ModelAndView view = new ModelAndView("/doctorlist");
		if (submit.equals("Cancel")) {
			try {
				view.addObject("d", doctorService.getAllDoctorComments());
			} catch (Exception e) {
				System.out.println(e);
			}
			return view;
		}
		doctorService.updateDoctorComments(d.getDoctor_comments(), id);
		view.addObject("d", doctorService.getAllDoctorComments());
		logger.info("Successfully updated the doctor comments");
		logger.debug("updated doctor comment " + doctorService.getAllDoctorComments());
		return view;
	}*/

	/* This method helps to update the doctor comments */
	@GetMapping("/updateDoctorComments/{id}")
	public String updateDoctorComments(@PathVariable("id") int id, Model model) {
		logger.info("Update doctor comment");
		model.addAttribute("d", doctorService.getDoctorCommentById(id));
		logger.debug("Doctorscomment updated successfully " + doctorService.getDoctorCommentById(id));
		return "updateDoctorComments";
	}

	/* This method helps to update the doctor comments */
	@PostMapping("/forgotpassword")
	public String saveNewPassword(@RequestParam("otp") int otp, @RequestParam("password") String password,
		 Model model, @ModelAttribute UserModel userModel,
			@RequestParam("submit") String submit) {
		logger.info("Change the password");
		User u = null;
		try {
			logger.info("sending OTP");
			u = userService.findByOtp(otp);
			logger.debug("OTP sent" + u);
		} catch (Exception e) {
			logger.error("Error " + e);
			System.out.println("User not found !!!");
			logger.info("OTP not sent");
		}

		if (u != null) {
			logger.info("Return to login page");
			if (u.getOtp() == otp) {
				String encodedPassword = this.bCryptPasswordEncoder.encode(userModel.getPassword());
				userModel.setPassword(encodedPassword);
				userService.changePassword(u, encodedPassword);
				logger.info("updated the password");

				return "login";

			}

			else {
				model.addAttribute("error", "Password and Confirm Password doesnot match");
				logger.error("Password does not match");
				return "forgotpassword";
			}

		}

		model.addAttribute("error", "Invalid Email");
		return "forgotpassword";

	}

	/* This method helps to update the doctor comments */
	@GetMapping("/forgotpassword")
	public String updatePassword() {
		logger.info("Changing password");
		return "forgotpassword";
	}

	@PostMapping("/sendotp")
	public String sendOTP(@RequestParam("email") String email, @ModelAttribute UserModel userModel) {
		User u = null;
		try {
			u = userService.findByEmail(email);
		} catch (Exception e) {
			logger.error("User not found");
			System.out.println("User not found !!!");
			logger.debug("user is " + email);
		}
		int otpgenerated = (int) Math.floor(Math.random() * 1000000);
		if (u != null) {
			System.out.println("test1");
			userService.setOtp(u, otpgenerated);
		}
		String to = email;
		String subject = "OTP Generation";
		String text = "OTP is: " + otpgenerated;
		emailService.SendMail(to, subject, text);
		//System.out.println(text);
		return "forgotpassword";
	}

	@GetMapping("/sendotp")
	public String Passwordverify() {
		logger.info("Sending OTP");
		return "sendotp";
	}

	/* Comment List */
	@GetMapping("/commentlist") // staff
	public String Comments(Model model) {
		logger.info("Showing commentlist");
		model.addAttribute("d", doctorService.getAllDoctorComments());
		logger.debug("Successfully displayed " + doctorService.getAllDoctorComments());
		return "commentlist";
	}

	/* Logout */
	@GetMapping("/logout")
	public String logout() {
		logger.info("Logging out");
		return "home";
	}
}
