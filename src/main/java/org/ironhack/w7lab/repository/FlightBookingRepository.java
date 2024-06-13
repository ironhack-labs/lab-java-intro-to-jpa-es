package org.ironhack.w7lab.repository;

import org.ironhack.w7lab.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
