package org.alvarowau.airlinecontrol.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flightId", referencedColumnName = "flightId")
    private Flight flight;

    // Constructor vacío
    public FlightBooking() {}

    // Constructor parametrizado
    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }


}
