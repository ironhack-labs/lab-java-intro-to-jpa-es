// Clase CustomerStatus--------------------------------
public enum CustomerStatus {
    GOLD,
    SILVER,
    NONE
}


//Clase Customer--------------------------------------
public class Customer {
    private int customerId;
    private String customerName;
    private CustomerStatus customerStatus;
    private  int totalCustomerMileage;

    public Customer () {
    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

}


//Clase Flight--------------------------------------------
public class Flight {
    private int flightId;
    private String flightNumber;
    private String aircraft;
    private int totalAircraftSeats;
    private int flightMileage;

    public Flight() {
    }

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
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

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }
}


//Clase FlightBooking----------------------------------
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private int flightId;

    public FlightBooking() {
    }

    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}


//Entidad y repositorio para Customer--------------------
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerName;
    private CustomerStatus customerStatus;
    private int totalCustomerMileage;

    public Customer() {
    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public int getCustomerId() { return customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public CustomerStatus getCustomerStatus() { return customerStatus; }
    public void setCustomerStatus(CustomerStatus customerStatus) { this.customerStatus = customerStatus; }

    public int getTotalCustomerMileage() { return totalCustomerMileage; }
    public void setTotalCustomerMileage(int totalCustomerMileage) { this.totalCustomerMileage = totalCustomerMileage; }
}

//Repositorio
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String name);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}


//Entidad y repositorio Flight---------------------------
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    private String flightNumber;
    private String aircraft;
    private int totalAircraftSeats;
    private int flightMileage;

    public Flight() {
    }

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public int getFlightId() { return flightId; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getAircraft() { return aircraft; }
    public void setAircraft(String aircraft) { this.aircraft = aircraft; }

    public int getTotalAircraftSeats() { return totalAircraftSeats; }
    public void setTotalAircraftSeats(int totalAircraftSeats) { this.totalAircraftSeats = totalAircraftSeats; }

    public int getFlightMileage() { return flightMileage; }
    public void setFlightMileage(int flightMileage) { this.flightMileage = flightMileage; }
}

//Repositorio
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String name);
    List<Flight> findByFlightMileageGreaterThan(int mileage);
}


//Entidad y Repositorio para FlightBooking---------------
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;

    public FlightBooking() {
    }

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}

//Repositorio
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    // Puedes añadir métodos personalizados aquí si es necesario
}


//Tests-----------------------------------------------
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    // Test para crear nuevos clientes
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 35000);
        customerRepository.save(customer);
        assertNotNull(customer.getCustomerId(), "El ID del cliente debería ser generado automáticamente.");
    }

    // Test para crear vuelos
    @Test
    public void testCreateFlight() {
        Flight flight = new Flight("DL555", "Boeing 747", 400, 1500);
        flightRepository.save(flight);
        assertNotNull(flight.getFlightId(), "El ID del vuelo debería ser generado automáticamente.");
    }

    // Test para encontrar clientes por el nombre
    @Test
    public void testFindCustomerByName() {
        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertFalse(customers.isEmpty(), "Debería encontrar al menos un cliente con el nombre John Doe.");
    }

    // Test para encontrar clientes por el estatus
    @Test
    public void testFindCustomerByStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertTrue(customers.size() > 0, "Debería encontrar clientes con estatus GOLD.");
    }

    // Test para encontrar vuelos por el número de vuelo
    @Test
    public void testFindFlightByNumber() {
        Flight flight = flightRepository.findByFlightNumber("DL555");
        assertNotNull(flight, "Debería encontrar un vuelo con el número DL555.");
    }

    // Test para encontrar aviones con nombres que contengan Boeing
    @Test
    public void testFindAircraftByNameContainsBoeing() {
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertTrue(flights.size() > 0, "Debería encontrar al menos un vuelo que tenga Boeing en el nombre de la aeronave.");
    }

    // Test para encontrar vuelos con una distancia mayor a 500 millas
    @Test
    public void testFindFlightsWithMileageGreaterThan500() {
        List<Flight> flights = flightRepository.findBy