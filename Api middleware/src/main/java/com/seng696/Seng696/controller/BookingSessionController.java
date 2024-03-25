package com.seng696.Seng696.controller;

import com.seng696.Seng696.dto.BookingSessionRequest;
import com.seng696.Seng696.dto.BookingSessionResponse;
import com.seng696.Seng696.entity.BookingSessionEntity;
import com.seng696.Seng696.entity.ParkingBookingEntity;
import com.seng696.Seng696.service.BookingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class BookingSessionController {

    private final BookingSessionService bookingSessionService;

    @Autowired
    public BookingSessionController(BookingSessionService bookingSessionService) {
        this.bookingSessionService = bookingSessionService;
    }

    @PostMapping("/exit")
    public ResponseEntity<BookingSessionResponse> processParkingExit(@RequestBody BookingSessionRequest exitRequest) {
        BookingSessionResponse exitResponse = bookingSessionService.processParkingExit(exitRequest);
        return ResponseEntity.ok(exitResponse);
    }

//    @GetMapping("/info")
//    public ResponseEntity<List<ParkingBookingEntity>> getUserBookingSessions(@RequestParam String userId) {
//        List<ParkingBookingEntity> bookingSessions = bookingSessionService.getUserBookingSessions(userName);
//        return ResponseEntity.ok(bookingSessions);
//    }
}
