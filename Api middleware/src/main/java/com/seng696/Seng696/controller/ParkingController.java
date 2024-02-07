package com.seng696.Seng696.controller;

import com.seng696.Seng696.entity.Parking;
import com.seng696.Seng696.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Parking>> getParkingList() {
        List<Parking> parkingList = parkingService.getAllParking();
        return ResponseEntity.ok(parkingList);
    }
}
