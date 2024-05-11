package com.ironhack.airline.repository;

import com.ironhack.airline.model.Customer;
import com.ironhack.airline.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
