package com.seng696.Seng696.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "booking_sessions")
public class  BookingSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    private Long bookingId;
    private LocalDateTime parkingOutTime;
    private LocalDateTime bookingTime;
    private Double calculatedBill;

}

