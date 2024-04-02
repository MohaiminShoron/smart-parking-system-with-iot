package com.seng696.Seng696.controller;

import com.seng696.Seng696.dto.ParkingBookingRequest;
import com.seng696.Seng696.dto.ParkingBookingResponse;
import com.seng696.Seng696.service.ParkingBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class ParkingBookingController {

    private final ParkingBookingService parkingBookingService;

    @Autowired
    public ParkingBookingController(ParkingBookingService parkingBookingService) {
        this.parkingBookingService = parkingBookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<ParkingBookingResponse> bookParkingSlot(@RequestBody ParkingBookingRequest bookingRequest) {
        ParkingBookingResponse bookingResponse = parkingBookingService.bookParkingSlot(bookingRequest);
        return ResponseEntity.ok(bookingResponse);
    }
}
