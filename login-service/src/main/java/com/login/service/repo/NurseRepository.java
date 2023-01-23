package com.login.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.service.entity.NurseDetails;

@Repository
public interface NurseRepository  extends JpaRepository<NurseDetails, Integer>{

}
