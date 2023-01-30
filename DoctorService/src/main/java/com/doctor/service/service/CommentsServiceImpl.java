package com.doctor.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.PatientDetails;
import com.doctor.service.repository.CommentsRepository;
@Service
public class CommentsServiceImpl implements CommentsService{
	private static final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);
	
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public Comments createComment(Comments comment) {
		logger.trace("Creating comment for patient: {}", comment.getPatients().getId());
		logger.debug("Saving comment in database: {}", comment);
		Comments createdComment = commentsRepository.save(comment);
		logger.info("Comment for patient {} created successfully", createdComment.getPatients().getId());
		return createdComment;
	}

	@Override
	public Comments getCommentsById(int commentId) {
		logger.trace("Getting comment with id: {}", commentId);
		logger.debug("Retrieving comment from database");
		Comments comment = commentsRepository.findById(commentId).get();
		logger.info("Comment with id {} retrieved successfully", commentId);
		return comment;
	}

	@Override
	public List<Comments> getCommentsBypatients(PatientDetails id){
		logger.trace("Getting comments for patient: {}", id);
		logger.debug("Retrieving comments from database");
		List<Comments> comments = commentsRepository.findAllCommentsBypatients(id);
		logger.info("Comments for patient {} retrieved successfully", id);
		return comments;
	}

}
