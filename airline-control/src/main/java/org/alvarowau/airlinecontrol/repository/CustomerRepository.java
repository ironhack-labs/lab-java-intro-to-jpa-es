package org.alvarowau.airlinecontrol.repository;

import org.alvarowau.airlinecontrol.model.Customer;
import org.alvarowau.airlinecontrol.model.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz para la gestión de la entidad {@link Customer}.
 * Esta interfaz extiende {@link JpaRepository}, lo que permite realizar operaciones
 * CRUD en la base de datos para la entidad {@link Customer}.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Busca una lista de clientes por su nombre.
     *
     * @param name El nombre del cliente que se desea buscar.
     * @return Una lista de clientes que coinciden con el nombre dado.
     */
    List<Customer> findByCustomerName(String name);

    /**
     * Busca una lista de clientes por su estatus.
     *
     * @param status El estatus del cliente que se desea buscar.
     * @return Una lista de clientes que coinciden con el estatus dado.
     */
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
