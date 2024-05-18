package com.miguelprojects.lab_3_04_introduccionjpa.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Flight_Bookings")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="flight_id")
    private int flightId;


    public FlightBooking() {    }

    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return bookingId == that.bookingId && customerId == that.customerId && flightId == that.flightId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, flightId);
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", flightId=" + flightId +
                '}';
    }
}
