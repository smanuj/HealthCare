package com.login.service.service;

import java.util.List;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.service.config.WebSecurityConfig;
import com.login.service.dao.UserDao;
import com.login.service.entity.DoctorDetails;
import com.login.service.entity.Hospital;
import com.login.service.entity.NurseDetails;
import com.login.service.entity.UserDetails;
import com.login.service.repo.DoctorRepository;
import com.login.service.repo.HospitalRepository;
import com.login.service.repo.Userrepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private Userrepository userrepo;
	
	@Autowired
	private DoctorService doctorservice;
	
	@Autowired
	private NurseService nurseservice;
	
	@Autowired
	private HospitalRepository hr;
	
	@Autowired
	private WebSecurityConfig websecurity;
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public UserDetails getbyemail(String email){
		return userrepo.findByEmail(email);
	}
	
	@Override
	public UserDetails saveuser(UserDetails user) {
		return userrepo.save(user);
	}

	@Override
	public List<UserDetails> getalluser() {
		return userrepo.findAll();
	}

	@Override
	public String savedoctor(UserDetails user) throws Exception  {
		int flag=0;
		try {
		List<UserDetails> users= userrepo.findAll();
		for(UserDetails user1:users) {
			if(user1.getEmail().equals(user.getEmail())) {
				flag=1;
			}
		}
		if(flag==1) {
			return "not";
		}
//	     Hospital h = user.getDoctordetails().getHospital();
//	     System.out.println("ggggggggggggggggggggggggggggggggg"+h);
//	     
		  DoctorDetails d = user.getDoctordetails();
		  int h = d.getHospital().getHospitalId();
		  System.out.println(d.getHospital().getHospitalId());
		  Hospital h1= hr.getById(h);
		  d.setApproval(false);
		  d.setAvaliability(true);
		  d.setHospital(h1);
		  DoctorDetails d1 = doctorservice.savedoctor(d);
		  String  dd=websecurity.passwordEncoder().encode(user.getPassword());
		  System.out.println("============================="+dd);
		  UserDetails u = new UserDetails(user.getEmail(),websecurity.passwordEncoder().encode(user.getPassword()), d1);
//		  u.setPassword(websecurity.passwordEncoder().encode(user.getPassword()));
		  userrepo.save(u);
		  return "saved";
		}
		
		catch (Exception e) {
			Hospital h = user.getDoctordetails().getHospital();
		     System.out.println(h);
			 DoctorDetails d = user.getDoctordetails();
			  d.setApproval(false);
			  d.setAvaliability(true);
			  d.setHospital(h);
			  DoctorDetails d1 = doctorservice.savedoctor(d);
			  String  dd=websecurity.passwordEncoder().encode(user.getPassword());
			  System.out.println("============================="+dd);
			  UserDetails u = new UserDetails(user.getEmail(),websecurity.passwordEncoder().encode(user.getPassword()), d1);
//			  u.setPassword(websecurity.passwordEncoder().encode(user.getPassword()));
			  userrepo.save(u);
			  return "saved";
		}
	}

	@Override
	public String savenurse(UserDetails user) {
		int flag=0;
		List<UserDetails> users= userrepo.findAll();
		for(UserDetails user1:users) {
			if(user1.getEmail().equals(user.getEmail())) {
				
				flag=1;
				
			}
		}
		if(flag==1) {
			return "not";
		}
		 NurseDetails n = user.getNursedetails();
		  n.setApproval(false);
		  n.setAvaliability(true);
		  NurseDetails n1 = nurseservice.savenurse(n);
		  UserDetails u = new UserDetails(user.getEmail(),websecurity.passwordEncoder().encode(user.getPassword()), n1);
		  
		  UserDetails u1 = userrepo.save(u); 
		  System.out.println("========"+u1);
		  return "saved";
	}

	@Override
	public String loginuser(UserDetails user) throws Exception {
		String pass = user.getPassword();
		String email=user.getEmail();
		try {
		UserDetails user2= userrepo.findByEmail(email);
		System.out.println("@@@@@@@@@"+user2);
		System.out.println("============"+user.getPassword());
		System.out.println("============"+user2.getPassword());
		if(user2!=null) {
			DoctorDetails d = user2.getDoctordetails();
			if(d==null) {
				NurseDetails n = user2.getNursedetails();
				System.out.println(websecurity.passwordEncoder().matches(user.getPassword(), user2.getPassword()));
				if(websecurity.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
					if(n.isApproval()) {
						return "successfully";
					}
					else {
						return "wait";
					}
					}
					else {
						return "pass";
					}
				}
			
		else {
			System.out.println(websecurity.passwordEncoder().matches(user.getPassword(), user2.getPassword()));
			if(websecurity.passwordEncoder().matches(user.getPassword(), user2.getPassword())) {
				if(d.isApproval()) {
					return "successfully";
				}
				else {
					return "wait";
				}
				}
				else {
					return "pass";
				}
			}
		}
		else {
			return "failed";
		}
		
			
		
		}
		catch (Exception e) {
			return "failed";
		}
		
		
	}
	
	@Override
	public void deletuser(int id) {
		userdao.deleteUser(id);
		
	}
	
	
}


