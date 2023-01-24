package com.doctor.service.service;

import com.doctor.service.entity.Comments;

public interface CommentsService {
	
	Comments createComment(Comments comment);
	
	Comments getCommentsById(int commentId);

}
