package com.example.lab304.repositoryTest;

import com.example.lab304.model.Flight;
import com.example.lab304.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepo;

    @Test
    @DisplayName("test to create new flights")
    public void testCreateFlight() {
        Flight flight = new Flight("DL140", "Boeing 747", 400, 135);
        Flight savedFlight = flightRepo.save(flight);

        assertNotNull(savedFlight.getFlightId());
        assertEquals("DL140", savedFlight.getFlightNumber());
        assertEquals("Boeing 747", savedFlight.getAircraft());
        assertEquals(400, savedFlight.getTotalAircraftSeats());
        assertEquals(135, savedFlight.getFlightMileage());

        System.out.println("Flight created successfully");
    }

    @Test
    @DisplayName("test to find flights by name")
    public void testFindByFlightNumber() {
        Flight flight = new Flight("DL140", "Boeing 747", 400, 135);
        Flight savedFlight = flightRepo.save(flight);
        Flight foundFlight = flightRepo.findByFlightNumber(savedFlight.getFlightNumber());
        assertEquals(savedFlight.getFlightNumber(), foundFlight.getFlightNumber());
        assertEquals(savedFlight.getAircraft(), foundFlight.getAircraft());
        System.out.println("Flight found successfully");
    }

    @Test
    @DisplayName("Test to find flights by aircraft name containing 'Boeing'")
    public void testFindByAircraft() {
        Flight flight1 = new Flight("DL100", "Boeing 777", 800, 1000);
        Flight flight2 = new Flight("DL100", "Airbus A320", 180, 1500);
        flightRepo.save(flight1);
        flightRepo.save(flight2);

        Flight boeingFlights = flightRepo.findByAircraftContaining("Boeing");
        assertEquals("Boeing 777", boeingFlights.getAircraft());
        System.out.println("Flight found successfully");
    }


    @Test
    @DisplayName("test to find flights with a distance greater than 500 miles")
    public void testFindAllByFlightMileageGreaterThan(){
        Flight flight1 = new Flight("DL100", "Boeing 777", 800, 1000);
        flightRepo.save(flight1);
        Flight flight2 = new Flight("DL100", "Boeing 777", 800, 600);
        flightRepo.save(flight2);
        Flight flight3 = new Flight("DL100", "Boeing 777", 800, 400);
        flightRepo.save(flight3);

        assertEquals(2, flightRepo.findAllByFlightMileageGreaterThan(500).size());
        System.out.println("Flight found successfully");
    }




}
