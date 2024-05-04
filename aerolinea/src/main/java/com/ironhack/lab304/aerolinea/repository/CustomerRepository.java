package com.ironhack.lab304.aerolinea.repository;

import com.ironhack.lab304.aerolinea.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByName(String johnDoe);

    Customer findByStatus(String silver);
    // Puedes agregar métodos personalizados si es necesario
}
