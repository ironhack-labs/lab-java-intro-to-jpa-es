package com.ironhack.lab304.aerolinea.repository;

import com.ironhack.lab304.aerolinea.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
