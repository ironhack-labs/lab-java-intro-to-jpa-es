package org.example.week6labs;

import org.example.week6labs.enums.CustomerStatus;
import org.example.week6labs.model.Customer;
import org.example.week6labs.model.Flight;
import org.example.week6labs.repository.CustomerRepository;
import org.example.week6labs.repository.FlightBookingRepository;
import org.example.week6labs.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {
  @Autowired
  private FlightRepository flightRepository;
  @Autowired
  private FlightBookingRepository flightBookingRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Override
  public void run(String... args) throws Exception {
    Customer customerDB = customerRepository.save(new Customer("Felipe", CustomerStatus.GOLD, 124));
    Customer customerDB1 = customerRepository.save(new Customer("Antonio", CustomerStatus.NONE, 124));
    Customer customerDB2 = customerRepository.save(new Customer("Lisa", CustomerStatus.SILVER, 124));
    Customer customerDB3 = customerRepository.save(new Customer("Luis", CustomerStatus.GOLD, 124));
    Customer customerDB4 = customerRepository.save(new Customer("Alvaro", CustomerStatus.SILVER, 124));
    Customer customerDB5 = customerRepository.save(new Customer("Sonia", CustomerStatus.NONE, 124));
    Flight flightDB = flightRepository.save(new Flight("AV234", "Boing747", 124, 0));
    Flight flightDB1 = flightRepository.save(new Flight("AB234", "Boing227", 124, 42));
    Flight flightDB2 = flightRepository.save(new Flight("AX234", "Boing007", 124, 212));
    Flight flightDB3 = flightRepository.save(new Flight("AC234", "Boing723", 124, 421));
    Flight flightDB4 = flightRepository.save(new Flight("AW234", "Boing747", 124, 422));

    for (Customer customer1 : customerRepository.findAll()) {
      System.out.println(customer1.getCustomerName());
    }
    for (Flight flight1 : flightRepository.findAll()) {
      System.out.println(flight1.getFlightNumber());
    }
    for (Customer customer2 : customerRepository.findAllByCustomerName("Antonio")) {
      System.out.println(customer2.getCustomerName() + " id: " + customer2.getId());
    }
    for (Customer customer2 : customerRepository.findAllByCustomerStatus(CustomerStatus.GOLD)) {
      System.out.println(customer2.getCustomerName() + " id: " + customer2.getId()+ " status: " + customer2.getCustomerStatus());
    }
    for (Flight flight : flightRepository.findAllByFlightNumber("AV234")) {
      System.out.println(flight.getFlightNumber() + " id: " + flight.getId());
    }
    for (Flight flight : flightRepository.findAllByAircarftContaining("Boing747")) {
      System.out.println(flight.getFlightNumber() + " id: " + flight.getId()+ " aircartf: " + flight.getAircarft());
    }
    for (Flight flight : flightRepository.findAllByFlightMileageGreaterThan(400)) {
      System.out.println(flight.getFlightNumber() + " id: " + flight.getId()+ " aircartf: " + flight.getAircarft() + " mileage: " + flight.getFlightMileage());
    }

  }
}
