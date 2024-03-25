package com.seng696.Seng696.repository;

import com.seng696.Seng696.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    // Add custom queries if needed
}
