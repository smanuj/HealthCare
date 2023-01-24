package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.UserDetails;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
