package com.ironhack.labjpa;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.CustomerStatus;
import com.ironhack.labjpa.model.Flight;
import com.ironhack.labjpa.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;

    Flight flight;
    Flight flight1;

    @BeforeEach
    void setUp() {
        flight = new Flight("DL143","Boeing 747",400,135);
        flight1 = new Flight("DL122","Airbus A330",236,4370);
        flightRepository.saveAll(List.of(flight, flight1));
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    public void testSaveFlight() {
        assertNotNull(flight.getFlightId());
        assertEquals("DL143", flight.getFlightNumber());
        assertEquals("Boeing 747", flight.getAircraft());
        assertEquals(400, flight.getTotalAircraftSeats());
        assertEquals(135, flight.getFlightMileage());
    }

    @Test
    public void testFindFlightByFlightNumber() {
        List<Flight> foundFlight = flightRepository.findByFlightNumber(flight.getFlightNumber());

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightNumber(), foundFlight.get(0).getFlightNumber());
    }

    @Test
    public void testFindFlightByAircraft() {
        List<Flight> boeingFlights = flightRepository.findByAircraftContains("Boeing");

        assertNotNull(boeingFlights);
        assertEquals(flight.getAircraft(), boeingFlights.get(0).getAircraft());
    }

    @Test
    public void testFindFlightsByFlightMileageGreatherThan500() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);

        assertNotNull(flights);
        assertTrue(flight1.getFlightMileage() > 500);
    }
}
