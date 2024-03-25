package com.seng696.Seng696.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int availableParkingSpot;
    private boolean openSpace;
    private boolean covered;
    private boolean accessibleSpot;
    private int openSpaceAvailability;
    private int coveredAvailability;
    private int accessibleSpotAvailability;
    private String minParkTime;
    private String operationHour;


}

