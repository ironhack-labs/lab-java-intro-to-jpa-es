package org.alvarowau.airlinecontrol.repository;

import org.alvarowau.airlinecontrol.model.Customer;
import org.alvarowau.airlinecontrol.model.enums.CustomerStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("Alvaro", CustomerStatus.GOLD, 1000);
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer);
        assertEquals("Alvaro", savedCustomer.getCustomerName());
        assertEquals(CustomerStatus.GOLD, savedCustomer.getCustomerStatus());
        assertNotNull(savedCustomer.getCustomerId());
        assertTrue(savedCustomer.getCustomerId() > 0);
    }

    @Test
    public void testFindCustomerByName(){
        customerRepository.save(new Customer("Álvaro", CustomerStatus.GOLD, 1000));
        customerRepository.save(new Customer("Alicia", CustomerStatus.SILVER, 1500));

        List<Customer> customers = customerRepository.findByCustomerName("Alicia");
        assertEquals(1, customers.size());
        assertEquals("Alicia", customers.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomerByStatus(){
        customerRepository.save(new Customer("Alvaro", CustomerStatus.GOLD, 1000));
        customerRepository.save(new Customer("Alicia", CustomerStatus.SILVER, 1500));

        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);

        assertEquals(1, customers.size());
        assertEquals(CustomerStatus.GOLD, customers.get(0).getCustomerStatus());
    }


}