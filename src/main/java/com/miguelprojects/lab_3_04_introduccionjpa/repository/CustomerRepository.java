package com.miguelprojects.lab_3_04_introduccionjpa.repository;

import com.miguelprojects.lab_3_04_introduccionjpa.model.Customer;
import com.miguelprojects.lab_3_04_introduccionjpa.model.CustomerStatus;
import com.miguelprojects.lab_3_04_introduccionjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerName(String name);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
