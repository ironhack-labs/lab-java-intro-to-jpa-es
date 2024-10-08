package org.example.week6labs.repository;

import org.example.week6labs.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
  List<Flight> findAllByFlightNumber(String flightNumber);
  List<Flight> findAllByAircarftContaining(String aircraftContaining);

  List<Flight> findAllByFlightMileageGreaterThan(Integer flightMileage);


}
