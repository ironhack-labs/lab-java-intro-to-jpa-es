package org.example.repository;

import org.example.model.Customer;
import org.example.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer>findByCustomerStatus(CustomerStatus customerStatus);
}
