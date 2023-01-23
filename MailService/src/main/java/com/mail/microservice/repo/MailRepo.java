package com.mail.microservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.microservice.entity.MailTable;


@Repository
public interface MailRepo  extends JpaRepository<MailTable, Integer>{

	List<MailTable> findAllBySentFalse();
}
