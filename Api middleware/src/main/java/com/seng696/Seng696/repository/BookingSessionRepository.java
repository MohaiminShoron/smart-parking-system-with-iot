package com.seng696.Seng696.repository;

import com.seng696.Seng696.entity.BookingSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingSessionRepository extends JpaRepository<BookingSessionEntity, Long> {

}

