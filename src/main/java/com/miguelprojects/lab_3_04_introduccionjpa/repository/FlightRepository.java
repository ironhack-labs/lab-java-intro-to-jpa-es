package com.miguelprojects.lab_3_04_introduccionjpa.repository;

import com.miguelprojects.lab_3_04_introduccionjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraft);

    @Query(value="SELECT f.flightNumber as Numero_Vuelo, f.aircraft as Aeronave, f.flightMileage as Distancia_Vuelo FROM Flight f WHERE f.flightMileage > :mileage")
    List<Object[]> findFlightsWithFlightMileageLongerThan(@Param("mileage") int mileage);

}
