package com.doctor.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.service.entity.NurseDetails;
@Repository
public interface NurseDetailsRepository extends JpaRepository<NurseDetails, Integer>{

	Optional<NurseDetails> findBynurseId(int nurseId);

}
