package com.seng696.Seng696.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "parking_lot_details")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private int capacity;
    private int availableParkingSpot;
    private boolean openSpace;
    private boolean covered;
    private boolean CCTV;
    private boolean gated;
    private boolean accessibleSpot;
    private int openSpaceAvailability;
    private int coveredAvailability;
    private int accessibleSpotAvailability;
    private String minParkTime;
    private String operationHour;
}

