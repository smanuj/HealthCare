package com.valtech.health.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.health.app.dao.DoctorDao;
import com.valtech.health.app.entity.Doctor;
import com.valtech.health.app.repostitory.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private DoctorDao doctorDao;

	/* This method creates Doctor Comments */
	@Override
	public Doctor createDoctor(Doctor d) {
		return doctorRepository.save(d);
	}

	/* This method lists all the Doctor Comments */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Doctor> getAllDoctorComments() {
		return doctorRepository.findAll();
	}

	/* This method lists all the Doctor Comments by ID */
	@Override
	public Doctor getDoctorCommentById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.getReferenceById(id);

	}

	/* This method finds Doctor Comments by their name */
	@Override
	public Doctor findByNursename(String nursename) {
		// TODO Auto-generated method stub
		return doctorRepository.findByNursename(nursename);
	}
	/* This method updates all the Doctor Comments */
	/*
	 * @Override public Doctor updateDoctorComments(Doctor d) { // TODO
	 * Auto-generated method stub return doctorRepository.save(d); }
	 */

	@Override
	public void updateDoctorComments(String doctor_comments, int id) {
		doctorDao.updateDoctorCommentsDao(doctor_comments, id);
	}
}
