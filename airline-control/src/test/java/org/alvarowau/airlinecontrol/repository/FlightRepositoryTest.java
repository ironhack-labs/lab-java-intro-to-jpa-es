package org.alvarowau.airlinecontrol.repository;

import org.alvarowau.airlinecontrol.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("F18", "Boeing",100,1000);
        Flight saveFlight = flightRepository.save(flight);
        assertNotNull(saveFlight);
        assertEquals("F18", saveFlight.getFlightName());
        assertEquals("Boeing", saveFlight.getAircraft());
        assertNotNull(saveFlight.getFlightId());
        assertTrue(saveFlight.getFlightId() > 0);
    }

    @Test
    public void testFindByNumber() {
        flightRepository.save( new Flight("F18", "Boeing",100,1000));
        Flight flight = flightRepository.findByFlightName("F18");
        assertNotNull(flight);
        assertEquals("F18", flight.getFlightName());
    }

    @Test
    public void testFindAircraftByContainingBoeing(){
        flightRepository.save( new Flight("F18", "Boeing",100,1000));
        flightRepository.save(new Flight("F20", "Airbus", 150, 800));

        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");

        assertEquals(1, flights.size());
        assertEquals("F18", flights.get(0).getFlightName());
    }

    @Test
    public void testFindFlightsWithMileageGreaterThan500() {
        flightRepository.save(new Flight("FL123", "Boeing 737", 180, 1000));
        flightRepository.save(new Flight("FL124", "Airbus A320", 150, 400));

        List<Flight> longDistanceFlights = flightRepository.findByFlightMileageGreaterThan(500);

        assertEquals(1, longDistanceFlights.size());
        assertTrue(longDistanceFlights.get(0).getFlightMileage() > 500);
    }

}