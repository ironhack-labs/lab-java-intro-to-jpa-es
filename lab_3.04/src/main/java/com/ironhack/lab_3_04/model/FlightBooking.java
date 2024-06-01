package com.ironhack.lab_3_04.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight_bookings")
public class FlightBooking {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "booking_id")
 private int bookingId;

 @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customer_id")
    private Customer customer;

 @ManyToOne
    @JoinColumn(name = "flightId", referencedColumnName = "flight_id")
    private Flight flight;

 public FlightBooking(){}

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return bookingId == that.bookingId && Objects.equals(customer, that.customer) && Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customer, flight);
    }
}
