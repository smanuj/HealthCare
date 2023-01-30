package com.patient.microservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.AadharDetails;
import com.patient.microservice.entity.Comments;
import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.entity.UserDetails;
import com.patient.microservice.facade.MailFacade;
import com.patient.microservice.repository.AadharRepository;
import com.patient.microservice.repository.CommentsRepository;
import com.patient.microservice.repository.DoctorDetailsRepository;
import com.patient.microservice.repository.PatientDetailsRepository;
import com.patient.microservice.repository.UserRepo;


@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Autowired
    private PatientDetailsRepository patientRepository;
    
    @Autowired
    private AadharRepository aadharRepository;
    
    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;
    
    @Autowired
    private CommentsRepository commentsRepository;
    
    @Autowired
    private MailFacade mailFacade;
    
    @Autowired
    private UserRepo userRepo;
     
    @Override
    public PatientDetails createPatientDetails(PatientDetails patient) {
    	int aadharNo= patient.getaId().getAadharNo();
    	AadharDetails a = aadharRepository.findByAadharNo(aadharNo);
    	patient.setaId(a);
    	patient.setStatus(false);
    	String spec = patient.getDisease();
    	System.out.println(spec);
    	DoctorDetails d = doctorDetailsRepository.findBySpecializationAndAvaliabilityTrue(spec);
    	System.out.println("d is : "+d);
    	patient.setDoctorId(d);
    	patient.setHospitalId(d.getHospitals());
    	Comments comm = new Comments();
    	comm.setDoctorId(d);
    	commentsRepository.save(comm);
    	patient.setCommentId(comm);
    	UserDetails usr = userRepo.findByDoctorDetails(d);
    	int userId = usr.getId();
    	mailFacade.alertDoctor(userId, patient);
        return patientRepository.save(patient);
    }
    
  
    @Override
    public List<PatientDetails> getAllPatients() {
    	System.out.println(patientRepository.findAll());
        return (List<PatientDetails>) patientRepository.findAll();
    }
	
}

	

