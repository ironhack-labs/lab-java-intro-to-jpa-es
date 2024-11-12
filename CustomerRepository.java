package com.example.SpringBootJpaApp.repository;

import com.example.SpringBootJpaApp.entity.Customer;
import com.example.SpringBootJpaApp.entity.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
