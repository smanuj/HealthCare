package com.doctor.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.service.entity.Comments;
import com.doctor.service.repository.CommentsRepository;
@Service
public class CommentsServiceImpl implements CommentsService{
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public Comments createComment(Comments comment) {
		return commentsRepository.save(comment);
	}

	@Override
	public Comments getCommentsById(int commentId) {
		return commentsRepository.findById(commentId).get();
	}
	
	

}
