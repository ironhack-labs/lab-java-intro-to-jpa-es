package com.ironhack.airline;

import com.ironhack.airline.model.Customer;
import com.ironhack.airline.model.CustomerStatus;
import com.ironhack.airline.model.Flight;
import com.ironhack.airline.repository.CustomerRepository;
import com.ironhack.airline.repository.FlightBookingRepository;
import com.ironhack.airline.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AirlineApplicationTests {


	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightBookingRepository flightBookingRepository;

	@Test
	void createCustomerTest() {
		Customer customer = new Customer("Marco Villasmil", CustomerStatus.Gold, 10000);

		Customer savedCustomer = customerRepository.save(customer);

		Customer fetchedCustomer = customerRepository.findById(savedCustomer.getCustomerId()).orElse(null);

		assertNotNull(fetchedCustomer);
		assertEquals("Marco Villasmil",fetchedCustomer.getCustomerName());
		assertEquals(CustomerStatus.Gold,fetchedCustomer.getCustomerStatus());
		assertEquals(Integer.valueOf(10000), fetchedCustomer.getTotalCustomerMileage());


	}

	@Test
	void createFlightTest() {
		Flight flight = new Flight("NEW123", "Boeing 737", 200, 7885);

		Flight savedFlight = flightRepository.save(flight);

		Flight fetchedFlight = flightRepository.findById(savedFlight.getFlightId()).orElse(null);

		assertNotNull(fetchedFlight);
		assertEquals("NEW123", fetchedFlight.getFlightNumber());
		assertEquals("Boeing 737", fetchedFlight.getAircraft());
		assertEquals(Integer.valueOf(200), fetchedFlight.getTotalAircraftSeats());
		assertEquals(Integer.valueOf(7885), fetchedFlight.getFlightMileage());
	}


	@Test
	void findCustomersByNameTest(){
		Customer customer1 = new Customer("Marco Villasmil", CustomerStatus.Gold, 10000);
		Customer customer2 = new Customer("Lisa Medina", CustomerStatus.Silver, 500);

		customerRepository.save(customer1);
		customerRepository.save(customer2);

		List<Customer> foundCustomers = customerRepository.findByCustomerName("Marco Villasmil");

		assertEquals(1, foundCustomers.size());
		assertEquals("Marco Villasmil", foundCustomers.get(0).getCustomerName());
		assertEquals(CustomerStatus.Gold, foundCustomers.get(0).getCustomerStatus());
		assertEquals(Integer.valueOf(10000), foundCustomers.get(0).getTotalCustomerMileage());

	}

	@Test
	void findCustomersByStatusTest(){
		Customer customer1 = new Customer("Marco Villasmil", CustomerStatus.Gold, 10000);
		Customer customer2 = new Customer("Lisa Medina", CustomerStatus.Silver, 500);

		customerRepository.save(customer1);
		customerRepository.save(customer2);

		List<Customer> foundCustomers = customerRepository.findByCustomerStatus(CustomerStatus.Gold);

		assertEquals(1, foundCustomers.size());
		assertEquals("Marco Villasmil", foundCustomers.get(0).getCustomerName());
		assertEquals(CustomerStatus.Gold, foundCustomers.get(0).getCustomerStatus());
		assertEquals(Integer.valueOf(10000), foundCustomers.get(0).getTotalCustomerMileage());
	}

	@Test
	void findFlightsByFlightNumberTest(){
		Flight flight1 = new Flight("NEW123", "Boeing 737", 200, 7885);
		Flight flight2 = new Flight("ABC555", "Airbus A320", 150, 2500);

		flightRepository.save(flight1);
		flightRepository.save(flight2);

		List<Flight> foundFlights = flightRepository.findByFlightNumber("NEW123");

		assertEquals(1, foundFlights.size());
		assertEquals("NEW123", foundFlights.get(0).getFlightNumber());
		assertEquals("Boeing 737", foundFlights.get(0).getAircraft());
		assertEquals(Integer.valueOf(200), foundFlights.get(0).getTotalAircraftSeats());
		assertEquals(Integer.valueOf(7885), foundFlights.get(0).getFlightMileage());
	}

	@Test
	void findFlightsByAircraftTest(){
		Flight flight1 = new Flight("NEW123", "Boeing 737", 200, 7885);
		Flight flight2 = new Flight("ABC555", "Airbus A320", 150, 2500);

		flightRepository.save(flight1);
		flightRepository.save(flight2);

		List<Flight> foundFlights = flightRepository.findByAircraftContaining("Boeing");

		assertEquals(1, foundFlights.size());
		assertEquals("NEW123", foundFlights.get(0).getFlightNumber());
		assertEquals("Boeing 737", foundFlights.get(0).getAircraft());
		assertEquals(Integer.valueOf(200), foundFlights.get(0).getTotalAircraftSeats());
		assertEquals(Integer.valueOf(7885), foundFlights.get(0).getFlightMileage());

	}

	@Test
	void findFlightsByMileageTest(){
		Flight flight1 = new Flight("NEW123", "Boeing 737", 200, 7885);
		Flight flight2 = new Flight("ABC555", "Airbus A320", 150, 500);

		flightRepository.save(flight1);
		flightRepository.save(flight2);

		List<Flight> foundFlights = flightRepository.findFlightsByMileageAbove(900);

		assertEquals(1, foundFlights.size());
		assertEquals("NEW123", foundFlights.get(0).getFlightNumber());
		assertEquals("Boeing 737", foundFlights.get(0).getAircraft());
		assertEquals(Integer.valueOf(200), foundFlights.get(0).getTotalAircraftSeats());
		assertEquals(Integer.valueOf(7885), foundFlights.get(0).getFlightMileage());
	}

	@Test
	void contextLoads(){

	}

}
