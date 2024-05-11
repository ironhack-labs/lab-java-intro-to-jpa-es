package com.ironhack.labjpa.repository;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerName(String customerName);

    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}