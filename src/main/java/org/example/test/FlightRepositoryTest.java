package org.example.test;

import org.example.model.Flight;
import org.example.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateFlight() {
        Flight flight = new Flight("AB123", "Boeing 737", 180, 500);
        Flight savedFlight = flightRepository.save(flight);
        assertThat(savedFlight).isNotNull();
        assertThat(savedFlight.getFlightId()).isNotNull();
    }

    @Test
    public void testFindFlightByNumber() {
        flightRepository.save(new Flight("CD456", "Airbus A320", 150, 400));
        Flight flight = flightRepository.findByFlightNumber("CD456");
        assertThat(flight).isNotNull();
        assertThat(flight.getFlightNumber()).isEqualTo("CD456");
    }

    @Test
    public void testFindAircraftByName() {
        flightRepository.save(new Flight("EF789", "Boeing 747", 400, 600));
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertThat(flights).isNotEmpty();
        assertThat(flights.get(0).getAircraft()).contains("Boeing");
    }

    @Test
    public void testFindFlightsByMileage() {
        flightRepository.save(new Flight("GH012", "Boeing 777", 300, 700));
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertThat(flights).isNotEmpty();
        assertThat(flights.get(0).getFlightMileage()).isGreaterThan(500);
    }
}