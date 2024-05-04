package com.ironhack.lab304.aerolinea.repository;

import com.ironhack.lab304.aerolinea.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);

    List<Flight> findByPlaneNameContaining(String boeing);

    List<Flight> findByDistanceGreaterThan(int i);
    // You can add custom query methods here if needed
}
