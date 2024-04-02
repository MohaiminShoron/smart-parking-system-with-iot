package com.seng696.Seng696.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "parking_bookings")
public class ParkingBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long placeId; // or String placeName, based on your requirement
    private String bookingType; // VIP/Normal
    private String carNumberPlate;
    private String userId; // or String userEmail, based on your requirement
    private LocalDateTime bookingDateTime;
    private LocalDateTime parkingInTime;
    private Long totalHoursStayed;

}
