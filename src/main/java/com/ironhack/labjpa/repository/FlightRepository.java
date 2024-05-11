package com.ironhack.labjpa.repository;

import com.ironhack.labjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flight);

    List<Flight> findByAircraftContains(String aircraft);

    List<Flight> findByFlightMileageGreaterThan(int mileage);
}
