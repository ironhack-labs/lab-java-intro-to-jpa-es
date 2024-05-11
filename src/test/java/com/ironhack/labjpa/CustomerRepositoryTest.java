package com.ironhack.labjpa;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.CustomerStatus;
import com.ironhack.labjpa.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	Customer customer ;
	Customer savedCustomer;

	@BeforeEach
	void setUp() {
		customer = new Customer("Agustine Riviera", CustomerStatus.SILVER, 115235);
		savedCustomer = customerRepository.save(customer);
	}

	@AfterEach
	void tearDown() {
		customerRepository.deleteAll();
	}

	@Test
	public void testSaveCustomer() {
		assertNotNull(savedCustomer.getCustomerId());
		assertEquals("Agustine Riviera", savedCustomer.getCustomerName());
		assertEquals(CustomerStatus.SILVER, savedCustomer.getCustomerStatus());
		assertEquals(115235, savedCustomer.getTotalCustomerMileage());
	}

	@Test
	public void testFindCustomerByCustomerName() {
		List<Customer> foundCustomer = customerRepository.findByCustomerName(savedCustomer.getCustomerName());

		assertNotNull(foundCustomer);
		assertEquals(savedCustomer.getCustomerName(), foundCustomer.get(0).getCustomerName());
	}

	@Test
	public void testFindCustomerByCustomerStatus() {
		List<Customer> foundCustomer = customerRepository.findByCustomerStatus(savedCustomer.getCustomerStatus());

		assertNotNull(foundCustomer);
		assertEquals(savedCustomer.getCustomerStatus(), foundCustomer.get(0).getCustomerStatus());
	}
}