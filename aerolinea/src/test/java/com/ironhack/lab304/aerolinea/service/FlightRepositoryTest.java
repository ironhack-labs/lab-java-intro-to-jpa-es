package com.ironhack.lab304.aerolinea.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ironhack.lab304.aerolinea.model.Flight;
import com.ironhack.lab304.aerolinea.repository.FlightRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testFindByAircraftContaining() {
        // Create a flight with an aircraft name containing "Boeing"
        Flight flight = new Flight("AB123", "Boeing 747", 300, 1000);
        flightRepository.save(flight);

        // Retrieve flights by aircraft name containing "Boeing"
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");

        // Check if the retrieved flight list contains the flight
        assertTrue(flights.contains(flight));
    }

    @Test
    public void testFindByFlightMileageGreaterThan() {
        // Create a flight with a mileage greater than 500
        Flight flight = new Flight("AB123", "Airbus A320", 200, 600);
        flightRepository.save(flight);

        // Retrieve flights with mileage greater than 500
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);

        // Check if the retrieved flight list contains the flight
        assertTrue(flights.contains(flight));
    }
}
