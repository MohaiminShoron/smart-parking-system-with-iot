package com.seng696.Seng696.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingSessionRequest {

    private Long bookingId;
    private LocalDateTime parkingOutTime;

}

