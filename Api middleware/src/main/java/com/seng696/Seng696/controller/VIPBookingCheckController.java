package com.seng696.Seng696.controller;

import com.seng696.Seng696.service.ParkingBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check-vip")
public class VIPBookingCheckController {

    private final ParkingBookingService parkingBookingService;

    @Autowired
    public VIPBookingCheckController(ParkingBookingService parkingBookingService) {
        this.parkingBookingService = parkingBookingService;
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkVIPBooking(@RequestParam String licensePlateNumber) {
        boolean isVIPBooking = parkingBookingService.checkVIPBooking(licensePlateNumber);
        return ResponseEntity.ok(isVIPBooking);
    }
}

