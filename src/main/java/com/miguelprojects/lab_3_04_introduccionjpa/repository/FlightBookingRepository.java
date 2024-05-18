package com.miguelprojects.lab_3_04_introduccionjpa.repository;

import com.miguelprojects.lab_3_04_introduccionjpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
