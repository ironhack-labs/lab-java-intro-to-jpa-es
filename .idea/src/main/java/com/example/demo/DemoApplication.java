package com.example.demo;

import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightBookingRepository flightBookingRepository;

	@Override
	public void run(String... args) throws Exception {
		// Create and save some customers and flights for testing
		Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 1000);
		customerRepository.save(customer);

		Flight flight = new Flight("AA123", "Boeing 737", 200, 500);
		flightRepository.save(flight);

		FlightBooking booking = new FlightBooking(customer.getCustomerId(), flight.getFlightId());
		flightBookingRepository.save(booking);

		// Testing the methods
		List<Customer> customersByName = customerRepository.findByCustomerName("John Doe");
		assertTrue(customersByName.size() > 0);

		List<Flight> flightsByNumber = flightRepository.findByFlightNumber("AA123");
		assertTrue(flightsByNumber.size() > 0);

		List<Flight> flightsByAircraft = flightRepository.findByAircraftContaining("Boeing");
		assertTrue(flightsByAircraft.size() > 0);

		List<Flight> flightsGreaterThan500Miles = flightRepository.findByFlightMileageGreaterThan(500);
		assertTrue(flightsGreaterThan500Miles.size() > 0);
	}
}

@Entity
class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName;
	@Enumerated(EnumType.STRING)
	private CustomerStatus customerStatus;
	private Integer totalCustomerMileage;

	public Customer() {}

	public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
		this.customerName = customerName;
		this.customerStatus = customerStatus;
		this.totalCustomerMileage = totalCustomerMileage;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Integer getTotalCustomerMileage() {
		return totalCustomerMileage;
	}

	public void setTotalCustomerMileage(Integer totalCustomerMileage) {
		this.totalCustomerMileage = totalCustomerMileage;
	}
}

enum CustomerStatus {
	GOLD, SILVER, NONE
}

@Entity
class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;
	private String flightNumber;
	private String aircraft;
	private Integer totalAircraftSeats;
	private Integer flightMileage;

	public Flight() {}

	public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
		this.flightNumber = flightNumber;
		this.aircraft = aircraft;
		this.totalAircraftSeats = totalAircraftSeats;
		this.flightMileage = flightMileage;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public Integer getTotalAircraftSeats() {
		return totalAircraftSeats;
	}

	public void setTotalAircraftSeats(Integer totalAircraftSeats) {
		this.totalAircraftSeats = totalAircraftSeats;
	}

	public Integer getFlightMileage() {
		return flightMileage;
	}

	public void setFlightMileage(Integer flightMileage) {
		this.flightMileage = flightMileage;
	}
}

@Entity
class FlightBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer customerId;
	private Integer flightId;

	public FlightBooking() {}

	public FlightBooking(Integer customerId, Integer flightId) {
		this.customerId = customerId;
		this.flightId = flightId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
}

interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByCustomerName(String customerName);
	List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}

interface FlightRepository extends JpaRepository<Flight, Integer> {
	List<Flight> findByFlightNumber(String flightNumber);
	List<Flight> findByAircraftContaining(String aircraft);
	List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}

interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {}

@SpringBootTest
class CustomerFlightTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Test
	void testFindCustomerByName() {
		Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 1000);
		customerRepository.save(customer);
		List<Customer> customers = customerRepository.findByCustomerName("John Doe");
		assertFalse(customers.isEmpty());
	}

	@Test
	void testFindFlightByNumber() {
		Flight flight = new Flight("AA123", "Boeing 737", 200, 500);
		flightRepository.save(flight);
		List<Flight> flights = flightRepository.findByFlightNumber("AA123");
		assertFalse(flights.isEmpty());
	}

	@Test
	void testFindFlightsContainingBoeing() {
		Flight flight = new Flight("AA123", "Boeing 737", 200, 500);
		flightRepository.save(flight);
		List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
		assertFalse(flights.isEmpty());
	}

	@Test
	void testFindFlightsGreaterThan500Miles() {
		Flight flight = new Flight("AA123", "Boeing 737", 200, 600);
		flightRepository.save(flight);
		List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
		assertFalse(flights.isEmpty());
	}
}
