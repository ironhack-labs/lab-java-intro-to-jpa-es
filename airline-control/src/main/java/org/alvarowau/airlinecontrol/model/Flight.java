package org.alvarowau.airlinecontrol.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    @Column(unique=true)
    private String flightName;
    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<FlightBooking> bookings;

    public Flight() {
        this.bookings = new ArrayList<>();
    }

    public Flight(String flightName, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightName = flightName;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
        this.bookings = new ArrayList<>();
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(Integer totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public Integer getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(Integer flightMileage) {
        this.flightMileage = flightMileage;
    }

    public List<FlightBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<FlightBooking> bookings) {
        this.bookings = bookings;
    }
}

