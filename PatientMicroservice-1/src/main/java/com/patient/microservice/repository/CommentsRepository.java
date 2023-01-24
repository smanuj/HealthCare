package com.patient.microservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patient.microservice.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

     List<Comments> findByDoctorIdAndNurseId(int doctorId, int nurseId);
	
    }

