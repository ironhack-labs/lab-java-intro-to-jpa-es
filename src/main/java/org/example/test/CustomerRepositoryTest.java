package org.example.test;

import org.example.model.Customer;
import org.example.model.CustomerStatus;
import org.example.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 1000);
        Customer savedCustomer = customerRepository.save(customer);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isNotNull();
    }

    @Test
    public void testFindCustomerByName() {
        customerRepository.save(new Customer("Jane Doe", CustomerStatus.SILVER, 800));
        List<Customer> customers = customerRepository.findByCustomerName("Jane Doe");
        assertThat(customers).isNotEmpty();
        assertThat(customers.get(0).getCustomerName()).isEqualTo("Jane Doe");
    }









    @Test
    public void testFindCustomerByStatus() {
        customerRepository.save(new Customer("Alice", CustomerStatus.GOLD, 1500));
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertThat(customers).isNotEmpty();
        assertThat(customers.get(0).getCustomerStatus()).isEqualTo(CustomerStatus.GOLD);
    }
}