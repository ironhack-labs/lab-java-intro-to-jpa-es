package com.ironhack.labjpa.repository;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
