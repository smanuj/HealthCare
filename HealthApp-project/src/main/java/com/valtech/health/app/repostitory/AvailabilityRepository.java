package com.valtech.health.app.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.valtech.health.app.entity.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {

}
