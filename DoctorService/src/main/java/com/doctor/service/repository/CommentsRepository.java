package com.doctor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{

}
