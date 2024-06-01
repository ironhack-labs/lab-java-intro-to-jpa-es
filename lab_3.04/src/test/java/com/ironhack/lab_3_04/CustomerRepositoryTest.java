package com.ironhack.lab_3_04;

import com.ironhack.lab_3_04.enums.CustomerStatus;
import com.ironhack.lab_3_04.model.Customer;
import com.ironhack.lab_3_04.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    public CustomerRepository customerRepository;

    private Integer customer1Id;
    private Integer customer2Id;
    private Integer customer3Id;

    @BeforeEach
    void setUp() {

        Customer customer = customerRepository.save(new Customer("Jaume", CustomerStatus.Gold, 2133));
        Customer customer2 = customerRepository.save(new Customer("Maria", CustomerStatus.Gold, 3150));
        Customer customer3 = customerRepository.save(new Customer("Pepe", CustomerStatus.None, 7189));

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
        Assertions.assertEquals(3, customerRepository.findAll().size());
        Customer customer = customerRepository.save(new Customer("Lola", CustomerStatus.Silver, 4012));
        Assertions.assertNotNull(customer.getCustomerId());
        // also could do: assertEquals(4,customerRepository.findAll().size());
    }

    @Test
    void findByCustomerName_validCustomerName_Customer() {
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Jaume");
        Assertions.assertTrue(customerOptional.isPresent());
        Assertions.assertEquals("Jaume", customerOptional.get().getCustomerName());
    }

    @Test
    void findByCustomerStatus_validCustomerStatus_Customers() {
        Assertions.assertEquals(2, customerRepository.findByCustomerStatus(CustomerStatus.Gold).size());
    }

}

