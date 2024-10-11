package com.example.flight_management.runner;

import com.example.flight_management.CustomerStatus;
import com.example.flight_management.model.Customer;
import com.example.flight_management.model.Flight;
import com.example.flight_management.repository.CustomerRepository;
import com.example.flight_management.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final FlightRepository flightRepository;

    public DataInitializer(CustomerRepository customerRepository, FlightRepository flightRepository) {
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save some sample customers with correct enum usage
        Customer customer1 = new Customer("John Doe", CustomerStatus.GOLD, 1500);
        Customer customer2 = new Customer("Jane Smith", CustomerStatus.SILVER, 800);
        Customer customer3 = new Customer("Alice Johnson", CustomerStatus.NONE, 300);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // Create and save some sample flights
        Flight flight1 = new Flight("AA123", "Boeing 747", 200, 600);
        Flight flight2 = new Flight("BA456", "Airbus A320", 180, 400);
        Flight flight3 = new Flight("CA789", "Boeing 777", 300, 900);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        // Log some outputs to verify the data is saved correctly
        customerRepository.findAll().forEach(customer ->
                System.out.println("Saved Customer: " + customer.getCustomerName() + ", Status: " + customer.getCustomerStatus())
        );

        flightRepository.findAll().forEach(flight ->
                System.out.println("Saved Flight: " + flight.getFlightNumber() + ", Aircraft: " + flight.getAircraft())
        );
    }
}
