package com.example.flight_management.repository;

import com.example.flight_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flight_management.CustomerStatus;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerNameContaining(String name);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
