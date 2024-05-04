package com.ironhack.lab304.aerolinea.model;

import jakarta.persistence.*;

@Entity
public class Flight {
    private Integer flightId;
    private String flightNumber;
    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;
    @Id
    private Long id;

    // Empty constructor for Hibernate
    public Flight() {}

    // Parameterized constructor
    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public Flight(String abc123, String s, int i) {
    }

    // Getter and setter methods
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
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

     public double getPlaneName() {
         return 0;
     }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getDistance() {
        return 0;
    }
}
