package com.seng696.Seng696.service;

import com.seng696.Seng696.entity.Parking;
import com.seng696.Seng696.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }
}

