package com.example.SpringBootJpaApp.repository;

import com.example.SpringBootJpaApp.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
