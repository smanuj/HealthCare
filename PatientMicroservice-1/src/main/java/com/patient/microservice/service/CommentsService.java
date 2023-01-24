package com.patient.microservice.service;

import java.util.List;

import com.patient.microservice.entity.Comments;


public interface CommentsService {

         List<Comments> getCommentsForDoctorIdandNurseId(int doctorId, int nurseId);
}