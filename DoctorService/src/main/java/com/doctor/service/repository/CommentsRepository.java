package com.doctor.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.Comments;
import com.doctor.service.entity.PatientDetails;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{

	List<Comments> findAllCommentsBypatients(PatientDetails id);


}
