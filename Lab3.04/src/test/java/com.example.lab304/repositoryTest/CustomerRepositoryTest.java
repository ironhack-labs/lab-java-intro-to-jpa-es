package com.example.lab304.repositoryTest;

import com.example.lab304.model.Customer;
import com.example.lab304.model.CustomerStatus;
import com.example.lab304.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepo;

    private Customer customer;
    private Customer savedCustomer;

    @Test
    @DisplayName("test to create new customers")
    public void testCreateCustomer() {
        customer = new Customer("Pepe Riviera", CustomerStatus.GOLD, 115235);
        savedCustomer = customerRepo.save(customer);

        assertNotNull(savedCustomer.getCustomerId());
        assertEquals("Pepe Riviera", savedCustomer.getCustomerName());
        assertEquals(CustomerStatus.GOLD, savedCustomer.getCustomerStatus());
        assertEquals(115235, savedCustomer.getTotalCustomerMileage());
        System.out.println("Customer created successfully");
    }

    @Test
    @DisplayName("test to find customers by name")
    public void testFindByCustomerName() {
        Customer customer1 = new Customer("John Doe", CustomerStatus.SILVER, 1000);
        customerRepo.save(customer1);

        List<Customer> customers = customerRepo.findByCustomerName("John Doe");
        assertEquals("John Doe", customers.get(0).getCustomerName());
        System.out.println("Customer found");
    }

    @Test
    @DisplayName("Test to find customers by status")
    public void testFindByCustomerStatus() {
        Customer customer1 = new Customer("Luis Lopez", CustomerStatus.SILVER, 1000);
        Customer customer2 = new Customer("Maria Martinez", CustomerStatus.NONE, 2000);
        Customer customer3 = new Customer("Roberto Rodriguez", CustomerStatus.GOLD, 3000);
        customerRepo.saveAll(List.of(customer1, customer2, customer3));

        List<Customer> goldCustomers = customerRepo.findByCustomerStatus(CustomerStatus.GOLD);
        List<Customer> silverCustomers = customerRepo.findByCustomerStatus(CustomerStatus.SILVER);
        List<Customer> noneCustomers = customerRepo.findByCustomerStatus(CustomerStatus.NONE);

        assertEquals("Luis Lopez", silverCustomers.get(0).getCustomerName());
        assertEquals("Maria Martinez", noneCustomers.get(0).getCustomerName());
        assertEquals("Roberto Rodriguez", goldCustomers.get(0).getCustomerName());

        System.out.println("Customers found");
    }
}