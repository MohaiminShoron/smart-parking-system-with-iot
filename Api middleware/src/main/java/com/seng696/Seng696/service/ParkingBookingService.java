package com.seng696.Seng696.service;

import com.seng696.Seng696.dto.ParkingBookingRequest;
import com.seng696.Seng696.dto.ParkingBookingResponse;
import com.seng696.Seng696.entity.ParkingBookingEntity;
import com.seng696.Seng696.entity.ParkingEntity;
import com.seng696.Seng696.repository.ParkingBookingRepository;
import com.seng696.Seng696.repository.ParkingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingBookingService {

    private final ParkingBookingRepository parkingBookingRepository;
    private final ParkingDetailsRepository parkingRepository;

    @Autowired
    public ParkingBookingService(ParkingBookingRepository parkingBookingRepository, ParkingDetailsRepository parkingRepository) {
        this.parkingBookingRepository = parkingBookingRepository;
        this.parkingRepository = parkingRepository;
    }

    public boolean checkVIPBooking(String licensePlateNumber) {
        // Check if there is any booking with the given license plate number and VIP booking type
        return parkingBookingRepository.existsByCarNumberPlateAndBookingType(licensePlateNumber, "VIP");
    }

    public ParkingBookingResponse bookParkingSlot(ParkingBookingRequest bookingRequest) {
        ParkingBookingEntity bookingEntity = new ParkingBookingEntity();
        bookingEntity.setPlaceId(bookingRequest.getPlaceId());
        bookingEntity.setBookingType(bookingRequest.getBookingType());
        bookingEntity.setCarNumberPlate(bookingRequest.getCarNumberPlate());
        bookingEntity.setUserId(bookingRequest.getUserId());
        bookingEntity.setBookingDateTime(bookingRequest.getBookingDateTime());
//        bookingEntity.setBookingDateTime(LocalDateTime.now());// Set current time as booking time

        ParkingBookingEntity savedBooking = parkingBookingRepository.save(bookingEntity);

        return convertToResponse(savedBooking);
    }

    private ParkingBookingResponse convertToResponse(ParkingBookingEntity bookingEntity) {
        ParkingEntity parkingEntity = parkingRepository.findById(bookingEntity.getPlaceId())
                .orElseThrow(() -> new RuntimeException("Parking lot not found"));

        ParkingBookingResponse bookingResponse = new ParkingBookingResponse();
        bookingResponse.setBookingId(bookingEntity.getBookingId());
        bookingResponse.setParkingLocationName(parkingEntity.getName());
        bookingResponse.setParkingAddress(parkingEntity.getAddress());
        bookingResponse.setParkingLatitude(parkingEntity.getLatitude());
        bookingResponse.setParkingLongitude(parkingEntity.getLongitude());
        bookingResponse.setBookingTime(bookingEntity.getBookingDateTime());
        bookingResponse.setParkingInTime(bookingEntity.getParkingInTime());
        bookingResponse.setTotalHoursStayed(bookingEntity.getTotalHoursStayed());

        return bookingResponse;
    }
}
