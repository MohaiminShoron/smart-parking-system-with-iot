package com.seng696.Seng696.service;

import com.seng696.Seng696.dto.BookingSessionRequest;
import com.seng696.Seng696.dto.BookingSessionResponse;
import com.seng696.Seng696.entity.BookingSessionEntity;
import com.seng696.Seng696.entity.ParkingBookingEntity;
import com.seng696.Seng696.repository.BookingSessionRepository;
import com.seng696.Seng696.repository.ParkingBookingRepository;
import com.seng696.Seng696.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingSessionService {

    private final BookingSessionRepository bookingSessionRepository;
    private final ParkingBookingRepository parkingBookingRepository;
    private final ParkingRepository parkingRepository;

    @Autowired
    public BookingSessionService(BookingSessionRepository bookingSessionRepository, ParkingBookingRepository parkingBookingRepository, ParkingRepository parkingRepository) {
        this.bookingSessionRepository = bookingSessionRepository;
        this.parkingBookingRepository = parkingBookingRepository;
        this.parkingRepository = parkingRepository;
    }

    public BookingSessionResponse processParkingExit(BookingSessionRequest exitRequest) {
        ParkingBookingEntity bookingEntity = parkingBookingRepository.findById(exitRequest.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        BookingSessionEntity sessionEntity = new BookingSessionEntity();
        sessionEntity.setBookingId(exitRequest.getBookingId());
        sessionEntity.setParkingOutTime(exitRequest.getParkingOutTime());
        sessionEntity.setBookingTime(bookingEntity.getBookingDateTime());

        LocalDateTime exitTime = sessionEntity.getParkingOutTime();
//        LocalDateTime exitTime= LocalDateTime.now();
        LocalDateTime bookingTime = sessionEntity.getBookingTime();
        long totalHoursStayed = calculateTotalHoursStayed(exitTime, bookingTime);
        sessionEntity.setCalculatedBill(calculateBill(totalHoursStayed));

        BookingSessionEntity savedSession = bookingSessionRepository.save(sessionEntity);

        return convertToResponse(bookingEntity, savedSession);
    }

    private long calculateTotalHoursStayed(LocalDateTime exitTime, LocalDateTime bookingTime) {
        return Math.max(0, (exitTime.minusMinutes(15).getHour() - bookingTime.getHour()));
    }

    private double calculateBill(long totalHoursStayed) {
        double hourlyRate = 5.0;
        return hourlyRate * totalHoursStayed;
    }

    private BookingSessionResponse convertToResponse(ParkingBookingEntity bookingEntity, BookingSessionEntity sessionEntity) {
        BookingSessionResponse response = new BookingSessionResponse();
        response.setBookingId(sessionEntity.getBookingId());
        response.setParkingLocationName("Your Parking Location Name"); // Set actual values
        response.setParkingAddress("Your Parking Address"); // Set actual values
        response.setBookingTime(sessionEntity.getBookingTime());
        response.setParkingInTime(bookingEntity.getParkingInTime());
        response.setParkingOutTime(sessionEntity.getParkingOutTime());
        response.setTotalBill(sessionEntity.getCalculatedBill());

        return response;
    }

}
