package com.mail.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.microservice.entity.MailTable;


@Repository
public interface MailRepo  extends JpaRepository<MailTable, Integer>{

	
}
