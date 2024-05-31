package org.example.repository;

import org.example.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Flight findByFlightNumber (String flightNumber);
    List<Flight> findByAircraftContaining(String aircraft);
    List<Flight>findByFlightMileageGreaterThan(Integer mileage);

}
