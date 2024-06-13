package org.ironhack.w7lab.repository;

import org.ironhack.w7lab.model.Customer;
import org.ironhack.w7lab.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerName(String customerName);

    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);

}
