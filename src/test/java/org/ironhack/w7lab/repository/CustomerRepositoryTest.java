package org.ironhack.w7lab.repository;

import org.ironhack.w7lab.model.Customer;
import org.ironhack.w7lab.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Integer customer1Id;
    private Integer customer2Id;
    private Integer customer3Id;

    @BeforeEach
    void setUp() {

        Customer customer = customerRepository.save(new Customer("Lourdes", CustomerStatus.GOLD, 10000));
        Customer customer2 = customerRepository.save(new Customer("Arthur", CustomerStatus.SILVER, 5000));
        Customer customer3 = customerRepository.save(new Customer("Merlin", CustomerStatus.NONE, 100));

        customer1Id = customer.getCustomerId();
        customer2Id = customer2.getCustomerId();
        customer3Id = customer3.getCustomerId();

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void saveCustomer_successful() {
        assertEquals(3, customerRepository.findAll().size());
        Customer customer = customerRepository.save(new Customer("Robin", CustomerStatus.SILVER, 4012));
        assertNotNull(customer.getCustomerId());
    }

    @Test
    void findByCustomerName_successful() {
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Lourdes");
        assertTrue(customerOptional.isPresent());
        assertEquals("Lourdes", customerOptional.get().getCustomerName());
    }

    @Test
    void findByCustomerStatus_validCustomerStatus_Customers() {
        assertEquals(1, customerRepository.findByCustomerStatus(CustomerStatus.GOLD).size());
    }

}