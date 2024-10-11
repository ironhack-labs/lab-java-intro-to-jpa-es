package com.example.flight_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;
    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;

    public Flight() {}

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    // Getters and setters
    public Integer getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public Integer getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public Integer getFlightMileage() {
        return flightMileage;
    }
}
