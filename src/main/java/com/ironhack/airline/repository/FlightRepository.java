package com.ironhack.airline.repository;


import com.ironhack.airline.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flight);
    List<Flight> findByAircraftContaining(String aircraft);


    @Query(value = "SELECT * FROM flight WHERE flight_mileage > :mileage", nativeQuery = true)
    List<Flight> findFlightsByMileageAbove(int mileage);
}
