package com.seng696.Seng696.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingBookingRequest {

//    private Long bookingId;
    private Long placeId; // or String placeName, based on your requirement
    private String bookingType; // VIP/Normal
    private String carNumberPlate;
    private String userId; // or String userEmail, based on your requirement
    private LocalDateTime bookingDateTime;

}
