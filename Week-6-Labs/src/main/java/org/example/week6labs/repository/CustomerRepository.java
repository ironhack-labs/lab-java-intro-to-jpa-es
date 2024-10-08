package org.example.week6labs.repository;

import org.example.week6labs.enums.CustomerStatus;
import org.example.week6labs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  List<Customer> findAllByCustomerName(String name);
  List<Customer> findAllByCustomerStatus(CustomerStatus status);
}
