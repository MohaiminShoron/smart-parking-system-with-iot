package com.seng696.Seng696.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingSessionResponse {

    private Long bookingId;
    private String parkingLocationName;
    private String parkingAddress;
    private LocalDateTime bookingTime;
    private LocalDateTime parkingInTime;
    private LocalDateTime parkingOutTime;
    private double totalBill;

}
