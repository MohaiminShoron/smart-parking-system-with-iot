package com.seng696.Seng696.controller;

import com.seng696.Seng696.entity.Parking;
import com.seng696.Seng696.entity.ParkingEntity;
import com.seng696.Seng696.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<ParkingEntity> getParkingDetails(@PathVariable Long id) {
        try {
            ParkingEntity parkingDetails = parkingService.getParkingDetails(id);
            return ResponseEntity.ok(parkingDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<ParkingDetailsResponse> getParkingDetails(@PathVariable Long id) {
//        try {
//            ParkingDetailsResponse parkingDetails = parkingService.getParkingDetails(id);
//            return ResponseEntity.ok(parkingDetails);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(404).body(null);
//        }
//    }
}
