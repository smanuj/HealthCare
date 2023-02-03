package com.patient.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservice.entity.Comments;
import com.patient.microservice.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService  {

	@Autowired
	private CommentsRepository commentsRepository;
	
//     @Override
//	public List<Comments> getCommentsForDoctorIdandNurseId(int doctorId, int nurseId) {
//	
//		  return commentsRepository.findByDoctorIdAndNurseId(doctorId, nurseId);
//	}



}
