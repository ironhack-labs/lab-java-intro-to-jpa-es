package com.ironhack.labjpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FlightBooking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flightId", referencedColumnName = "flightId")
    private Flight flight;

    public FlightBooking() {
    }

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}