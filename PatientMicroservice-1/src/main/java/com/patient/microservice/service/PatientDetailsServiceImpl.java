package com.patient.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.AadharDetails;
import com.patient.microservice.entity.DoctorDetails;
import com.patient.microservice.entity.NurseDetails;
import com.patient.microservice.entity.PatientDetails;
import com.patient.microservice.facade.LoginFacade;
import com.patient.microservice.facade.MailFacade;
import com.patient.microservice.repository.AadharRepository;
import com.patient.microservice.repository.DoctorDetailsRepository;
import com.patient.microservice.repository.NurseRepository;
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
    private NurseRepository nurseRepository;
    
    @Autowired
    private MailFacade mailFacade;
    
    @Autowired
    private LoginFacade loginFacade;
    
     
    @Override
    public PatientDetails createPatientDetails(PatientDetails patient) {
    	int aadharNo= patient.getaId().getAadharNo();
    	AadharDetails a = aadharRepository.findByAadharNo(aadharNo);
    	patient.setaId(a);
    	patient.setStatus(false);
    	int nid= patient.getNurseId().getNurseId();
    	NurseDetails nurse = loginFacade.genursebyid(nid);
    	nurse.setAvaliability(false);
    	nurseRepository.save(nurse);
    	patient.setNurseId(nurse);
    	String spec = patient.getDisease();
    	System.out.println(spec);
    	DoctorDetails d = doctorDetailsRepository.findBySpecializationAndAvaliabilityTrue(spec);
    	System.out.println("d is : "+d);
    	patient.setDoctorId(d);
    	d.setAvaliability(false);
    	doctorDetailsRepository.save(d);
    	patient.setDoctorId(d);
//    	UserDetails usr = userRepo.findByDoctorDetails(d);
//    	int userId = usr.getId();
//    	mailFacade.alertDoctor(userId, patient);
        return patientRepository.save(patient);
    }
    
  
    @Override
    public List<PatientDetails> getAllPatients() {
    	System.out.println(patientRepository.findAll());
        return (List<PatientDetails>) patientRepository.findAll();
    }
    
    @Override
    public void treatmentComplete(PatientDetails pd) {
    	pd.setStatus(true);
    	patientRepository.save(pd);
    }
    
    @Override
	public PatientDetails getPatientDetailsById(int id) {
		return patientRepository.findById(id).get();
	}
	
}

	
