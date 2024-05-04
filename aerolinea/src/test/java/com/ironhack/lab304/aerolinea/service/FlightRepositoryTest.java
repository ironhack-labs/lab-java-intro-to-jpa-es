package com.ironhack.lab304.aerolinea.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
@Transactional
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testFindFlightByFlightNumber() {
        // Create a new flight
        Flight newFlight = new Flight("BA123", "Boeing 747", 600);

        // Save the flight
        Flight savedFlight = flightRepository.save(newFlight);

        // Retrieve the flight by flight number
        Flight retrievedFlight = flightRepository.findByFlightNumber("BA123");

        // Verify that the flight was retrieved successfully
        assertNotNull(retrievedFlight);
        assertEquals(savedFlight.getFlightNumber(), retrievedFlight.getFlightNumber());
    }

    @Test
    public void testFindPlanesByNameContaining() {
        // Create flights with plane names containing "Boeing"
        Flight boeingFlight1 = new Flight("BA123", "Boeing 747", 600);
        Flight boeingFlight2 = new Flight("BA456", "Airbus A320", 500);
        Flight boeingFlight3 = new Flight("BA789", "Boeing 777", 700);

        // Save the flights
        flightRepository.save(boeingFlight1);
        flightRepository.save(boeingFlight2);
        flightRepository.save(boeingFlight3);

        // Find flights with plane names containing "Boeing"
        List<Flight> boeingFlights = flightRepository.findByPlaneNameContaining("Boeing");

        // Verify that the correct number of flights were retrieved
        assertEquals(2, boeingFlights.size());
    }

    @Test
    public void testFindFlightsByDistanceGreaterThan() {
        // Create flights with distances greater than 500 miles
        Flight longFlight1 = new Flight("BA123", "Boeing 747", 600);
        Flight longFlight2 = new Flight("BA456", "Airbus A320", 700);
        Flight shortFlight = new Flight("BA789", "Boeing 777", 400);

        // Save the flights
        flightRepository.save(longFlight1);
        flightRepository.save(longFlight2);
        flightRepository.save(shortFlight);

        // Find flights with distances greater than 500 miles
        List<Flight> longFlights = flightRepository.findByDistanceGreaterThan(500);

        // Verify that the correct number of flights were retrieved
        assertEquals(2, longFlights.size());
    }
}
