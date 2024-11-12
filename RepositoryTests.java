package com.example.springbootjpa;

import static org.junit.jupiter.api.Assertions.*;

import com.example.SpringBootJpaApp.entity.Customer;
import com.example.SpringBootJpaApp.entity.CustomerStatus;
import com.example.SpringBootJpaApp.entity.Flight;
import com.example.SpringBootJpaApp.repository.CustomerRepository;
import com.example.SpringBootJpaApp.repository.FlightBookingRepository;
import com.example.SpringBootJpaApp.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 50000);
        customerRepository.save(customer);
        assertNotNull(customer.getCustomerId());
    }

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("DL123", "Boeing 737", 180, 1000);
        flightRepository.save(flight);
        assertNotNull(flight.getFlightId());
    }

    @Test
    public void testFindCustomerByName() {
        Customer customer = customerRepository.findByCustomerName("John Doe");
        assertNotNull(customer);
    }

    @Test
    public void testFindCustomerByStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertFalse(customers.isEmpty());
    }

    @Test
    public void testFindFlightByNumber() {
        Flight flight = flightRepository.findByFlightNumber("DL123");
        assertNotNull(flight);
    }

    @Test
    public void testFindAircraftContainingBoeing() {
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertFalse(flights.isEmpty());
    }

    @Test
    public void testFindFlightByMileageGreaterThan500() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertFalse(flights.isEmpty());
    }
}
