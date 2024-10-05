package org.alvarowau.airlinecontrol.repository;

import org.alvarowau.airlinecontrol.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz para la gestión de la entidad {@link Flight}.
 * Esta interfaz extiende {@link JpaRepository}, permitiendo realizar operaciones
 * CRUD en la base de datos para la entidad {@link Flight}.
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    /**
     * Busca un vuelo por su nombre.
     *
     * @param name El nombre del vuelo que se desea buscar.
     * @return El vuelo que coincide con el nombre dado, o null si no se encuentra.
     */
    Flight findByFlightName(String name);

    /**
     * Busca una lista de vuelos cuyos nombres de aeronave contienen una cadena específica.
     *
     * @param name La cadena que se desea buscar en el nombre del avión.
     * @return Una lista de vuelos que contienen el nombre de aeronave especificado.
     */
    List<Flight> findByAircraftContaining(String name);

    /**
     * Busca una lista de vuelos con una distancia mayor a la especificada.
     *
     * @param millage La distancia mínima en millas que deben tener los vuelos.
     * @return Una lista de vuelos cuya distancia es mayor que el valor especificado.
     */
    List<Flight> findByFlightMileageGreaterThan(int millage);
}
