package com.ironhack.lab_3_04.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "aircraft")
    private String aircraft;

    @Column(name = "total_aircraft_seats")
    private int totalAircraftSeats;

    @Column(name = "flight_mileage")
    private int flightMileage;

    @OneToMany(mappedBy = "flight")
    List<FlightBooking> bookings;

    public Flight(){}

    public Flight(int flightId, String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage, List<FlightBooking> bookings) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
        this.bookings = bookings;
    }

    public Flight(String flightNumber, int totalAircraftSeats, String aircraft, int flightMileage) {
        this.flightNumber = flightNumber;
        this.totalAircraftSeats = totalAircraftSeats;
        this.aircraft = aircraft;
        this.flightMileage = flightMileage;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }

    public List<FlightBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<FlightBooking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && totalAircraftSeats == flight.totalAircraftSeats && flightMileage == flight.flightMileage && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, aircraft, totalAircraftSeats, flightMileage);
    }
}