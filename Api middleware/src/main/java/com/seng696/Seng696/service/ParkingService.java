package com.seng696.Seng696.service;

import com.seng696.Seng696.dto.ParkingDetailsResponse;
import com.seng696.Seng696.entity.Parking;
import com.seng696.Seng696.entity.ParkingEntity;
import com.seng696.Seng696.repository.ParkingDetailsRepository;
import com.seng696.Seng696.repository.ParkingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingDetailsRepository parkingDetailsRepository;

//    private final ModelMapper modelMapper;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository,ParkingDetailsRepository parkingDetailsRepository) {
        this.parkingDetailsRepository = parkingDetailsRepository;
//        this.modelMapper = modelMapper;, ModelMapper modelMapper
        this.parkingRepository = parkingRepository;
    }

//    @Autowired
//    public ParkingService(ParkingRepository parkingRepository) {
//        this.parkingRepository = parkingRepository;
//    }

    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

//    public ParkingDetailsResponse getParkingDetails(Long parkingId) {
//        ParkingEntity parkingEntity = parkingDetailsRepository.findById(parkingId)
//                .orElseThrow(() -> new RuntimeException("Parking details not found"));
//
//        return convertToResponse(parkingEntity);
//    }

    public ParkingEntity getParkingDetails(Long parkingId) {
        ParkingEntity parkingEntity = parkingDetailsRepository.findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking details not found"));

        return parkingEntity;
    }

//    private ParkingDetailsResponse convertToResponse(ParkingEntity parkingEntity) {
//        return modelMapper.map(parkingEntity, ParkingDetailsResponse.class);
//    }
}

