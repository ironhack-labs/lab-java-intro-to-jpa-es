package com.miguelprojects.lab_3_04_introduccionjpa;


import com.miguelprojects.lab_3_04_introduccionjpa.model.Customer;
import com.miguelprojects.lab_3_04_introduccionjpa.model.CustomerStatus;
import com.miguelprojects.lab_3_04_introduccionjpa.model.Flight;
import com.miguelprojects.lab_3_04_introduccionjpa.model.FlightBooking;
import com.miguelprojects.lab_3_04_introduccionjpa.repository.CustomerRepository;
import com.miguelprojects.lab_3_04_introduccionjpa.repository.FlightBookingRepository;
import com.miguelprojects.lab_3_04_introduccionjpa.repository.FlightRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookingRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightBookingRepository flightBookingRepository;

    private List<Customer> customers;
    private List<Flight> flights;
    private List<FlightBooking> flightBookings;

    @BeforeEach
    void setUp() {

        customers = customerRepository.saveAll(List.of(
                new Customer("Agustine Riviera", CustomerStatus.SILVER, 115235),
                new Customer("Alaina Sepulvida", CustomerStatus.NONE, 6008),
                new Customer("Tom Jones", CustomerStatus.GOLD, 205767),
                new Customer("Sam Rio", CustomerStatus.NONE, 2653),
                new Customer("Jessica James", CustomerStatus.SILVER, 127656),
                new Customer("Ana Janco", CustomerStatus.SILVER, 136773),
                new Customer("Jennifer Cortez", CustomerStatus.GOLD, 300582),
                new Customer("Christian Janco", CustomerStatus.SILVER, 14642)
        ));

        flights = flightRepository.saveAll(List.of(
                new Flight("DL143", "Boeing 747", 400, 135),
                new Flight("DL122", "Airbus A330", 236, 4370),
                new Flight("DL53" , "Boeing 777", 264, 2078),
                new Flight("DL222", "Boeing 777", 264, 1765),
                new Flight("DL37" , "Boeing 747", 400, 531)
        ));

        flightBookings = flightBookingRepository.saveAll(List.of(
                new FlightBooking(1, 1),
                new FlightBooking(1, 2),
                new FlightBooking(2, 2),
                new FlightBooking(1, 1),
                new FlightBooking(3, 2),
                new FlightBooking(3, 3),
                new FlightBooking(1, 1),
                new FlightBooking(4, 1),
                new FlightBooking(1, 1),
                new FlightBooking(3, 4),
                new FlightBooking(5, 1),
                new FlightBooking(4, 1),
                new FlightBooking(6, 4),
                new FlightBooking(7, 4),
                new FlightBooking(5, 2),
                new FlightBooking(4, 5),
                new FlightBooking(8, 4)
        ));

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
        flightRepository.deleteAll();
        flightBookingRepository.deleteAll();
    }

    //Escribe pruebas para verificar tu capacidad para crear nuevos clientes.
    @Test
    @DisplayName("Creating Customers_OK")
    public void createCustomer(){
        Customer randomCustomer = new Customer("Pablo Prieto", CustomerStatus.GOLD, 23451);
        customerRepository.save(randomCustomer);
        List<Customer> result = customerRepository.findAll();
        assertEquals(result.getLast(), randomCustomer);
    }

    //Escribe pruebas para verificar tu capacidad para crear nuevos vuelos.
    @Test
    @DisplayName("Creating Flights_OK")
    public void createFlight(){
        Flight newFlight = new Flight("DL250", "Airbus 550", 300, 1150);
        flightRepository.save(newFlight);
        List<Flight> result = flightRepository.findAll();
        assertEquals(result.getLast(), newFlight);
    }

//Escribe pruebas para verificar tu capacidad para encontrar clientes por nombre.
    @Test
    @DisplayName("Find Customers by Name_OK")
    public void findCustomersByName(){
        Customer customer = customerRepository.findByCustomerName("Agustine Riviera");
        assertEquals(customer, customers.getFirst());
    }

    //Escribe pruebas para verificar tu capacidad para encontrar clientes por estatus.
    @Test
    @DisplayName("Find Customers by Status_OK")
    public void findCustomersByStatus(){
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertEquals(4, customers.size());
    }

    //Escribe pruebas para verificar tu capacidad para encontrar vuelos por número de vuelo.
    @Test
    @DisplayName("Find Flights by FlightNumber_OK")
    public void findFlightsByFlightNumber(){
        List<Flight> flights = flightRepository.findByFlightNumber("DL143");
        assertEquals("Boeing 747", flights.get(0).getAircraft());
    }

    //Escribe pruebas para verificar tu capacidad para encontrar aviones con nombres que contengan "Boeing".
    @Test
    @DisplayName("Find Flights by Aircraft Containing_OK")
    public void findFlightsByAircraftContaining(){
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(4, flights.size());
    }

    //Escribe pruebas para verificar tu capacidad para encontrar vuelos con una distancia mayor a 500 millas.
    @Test
    @DisplayName("Find Flights Whit Flight Mileage Longer Than 500_OK")
    public void findFlightsWithFlightMileageLongerThan(){
        List<Object[]> result = flightRepository.findFlightsWithFlightMileageLongerThan(500);
        assertEquals(4, result.size());
    }
}
