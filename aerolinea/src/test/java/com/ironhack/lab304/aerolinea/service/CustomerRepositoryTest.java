package com.ironhack.lab304.aerolinea.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ironhack.lab304.aerolinea.model.Customer;
import com.ironhack.lab304.aerolinea.model.Flight;
import com.ironhack.lab304.aerolinea.repository.CustomerRepository;
import com.ironhack.lab304.aerolinea.repository.FlightRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateFlight() {
        // Create a new flight
        Flight newFlight = new Flight("ABC123", "Boeing 747", 600);

        // Save the flight
        Flight savedFlight = flightRepository.save(newFlight);

        // Retrieve the saved flight from the database
        Flight retrievedFlight = flightRepository.findByFlightNumber(savedFlight.getFlightNumber());

        // Verify that the flight was saved and retrieved successfully
        assertNotNull(retrievedFlight);
        assertEquals("ABC123", retrievedFlight.getFlightNumber());
        assertEquals("Boeing 747", retrievedFlight.getAircraft());
        assertEquals(600, retrievedFlight.getDistance());
    }

    @Test
    public void testFindCustomerByName() {
        // Create a new customer
        Customer newCustomer = new Customer("John Doe", "Gold");
        customerRepository.save(newCustomer);

        // Find the customer by name
        Customer foundCustomer = customerRepository.findByName("John Doe");

        // Verify that the customer was found
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
        assertEquals("Gold", foundCustomer.getStatus());
    }

    @Test
    public void testFindCustomerByStatus() {
        // Create a new customer
        Customer newCustomer = new Customer("Jane Smith", "Silver");
        customerRepository.save(newCustomer);

        // Find the customer by status
        Customer foundCustomer = customerRepository.findByStatus("Silver");

        // Verify that the customer was found
        assertNotNull(foundCustomer);
        assertEquals("Jane Smith", foundCustomer.getName());
        assertEquals("Silver", foundCustomer.getStatus());
    }
}