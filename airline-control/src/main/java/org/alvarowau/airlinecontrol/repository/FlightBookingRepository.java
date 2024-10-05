package org.alvarowau.airlinecontrol.repository;

import org.alvarowau.airlinecontrol.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz para la gestión de la entidad {@link FlightBooking}.
 * Esta interfaz extiende {@link JpaRepository}, permitiendo realizar operaciones
 * CRUD en la base de datos para la entidad {@link FlightBooking}.
 */
@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
