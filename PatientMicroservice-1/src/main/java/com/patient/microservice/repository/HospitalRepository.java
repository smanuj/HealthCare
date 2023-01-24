package com.patient.microservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patient.microservice.entity.Hospital;

@Repository

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
    List<Hospital> findByPincode(String pincode);
  }
//public interface HospitalRepository extends JpaRepository<Hospital, Long> {
//    @Query("SELECT h FROM Hospital h WHERE h.latitude = :latitude AND h.longitude = :longitude")
//    List<Hospital> findByLatitudeAndLongitude(@Param("latitude") double latitude, @Param("longitude") double longitude);
//}
