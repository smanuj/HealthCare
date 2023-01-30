package com.doctor.service.service;

import java.util.List;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.PatientDetails;

public interface CommentsService {
	
	Comments createComment(Comments comment);
	
	Comments getCommentsById(int commentId);

	List<Comments> getCommentsBypatients(PatientDetails id);



}
