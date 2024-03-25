package com.seng696.Seng696.controller;

import com.seng696.Seng696.dto.BookingSessionRequest;
import com.seng696.Seng696.dto.BookingSessionResponse;
import com.seng696.Seng696.service.BookingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
