package com.seng696.Seng696.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingBookingResponse {
    private Long bookingId;
    private String parkingLocationName;
    private String parkingAddress;
    private double parkingLatitude;
    private double parkingLongitude;
    private LocalDateTime bookingTime;
    private LocalDateTime parkingInTime;
    private Long totalHoursStayed;

    // Constructors, getters, setters, and other methods
}
