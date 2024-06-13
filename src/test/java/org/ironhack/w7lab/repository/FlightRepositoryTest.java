package org.ironhack.w7lab.repository;

import org.ironhack.w7lab.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp(){
        Flight flight = flightRepository.save(new Flight("ABC123", "Boeing 737", 150, 1000));
        Flight flight2 = flightRepository.save(new Flight("XYZ789", "Airbus A320", 180, 1200));
        Flight flight3 = flightRepository.save(new Flight("DEF456", "Boeing 747", 200, 450));
    }

    @AfterEach
    void tearDown(){
        flightRepository.deleteAll();
    }

    @Test
    void saveFlight_successful(){
        assertEquals(3, flightRepository.findAll().size());
        Flight flight = flightRepository.save(new Flight("GHI890", "Airbus A350", 200, 1500));
        assertNotNull(flight.getFlightId());
    }

    @Test
    void findByFlightNumber_successful(){
        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("ABC123");
        assertTrue(flightOptional.isPresent());
        assertEquals("ABC123", flightOptional.get().getFlightNumber());
    }

    @Test
    void findByAircraftContaining_successful(){
        List<Flight> flightsList = flightRepository.findByAircraftContaining("Boeing");
        Assertions.assertEquals(2, flightsList.size());
    }

    @Test
    void findByFlightMileageGreaterThan_successful(){
        List<Flight> flightsList = flightRepository.findByFlightMileageGreaterThan(500);
        Assertions.assertEquals(2, flightsList.size());
    }


}