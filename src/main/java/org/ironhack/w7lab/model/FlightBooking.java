package org.ironhack.w7lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight_history")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_booking_id")
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flight flight;

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public FlightBooking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
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
        return Objects.equals(getBookingId(), that.getBookingId()) && Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getFlight(), that.getFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCustomer(), getFlight());
    }
}
