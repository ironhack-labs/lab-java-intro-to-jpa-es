package com.example.lab304.repository;

import com.example.lab304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);

    Flight findByAircraftContaining(String aircraft);

    // para encontrar vuelos con una distancia mayor a 500 millas.
    List<Flight> findAllByFlightMileageGreaterThan(int mileage);

//    @Query("SELECT flightId FROM Flight HAVING flightMileage > :milege")
//    List<Objects[]> findAllByFlightMileageGreaterThan(@Param("mileage") int mileage);

}