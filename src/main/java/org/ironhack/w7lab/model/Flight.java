package org.ironhack.w7lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight" )
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "aircraft_type")
    private String aircraft;

    @Column(name = "total_seats")
    private Integer totalAircraftSeats;

    @Column(name = "flight_mileage")
    private Integer flightMileage;

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public Flight() {

    }

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

    public void setAircraft(String aircraftType) {
        this.aircraft = aircraftType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getFlightId(), flight.getFlightId()) && Objects.equals(getFlightNumber(), flight.getFlightNumber()) && Objects.equals(getAircraft(), flight.getAircraft()) && Objects.equals(getTotalAircraftSeats(), flight.getTotalAircraftSeats()) && Objects.equals(getFlightMileage(), flight.getFlightMileage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightId(), getFlightNumber(), getAircraft(), getTotalAircraftSeats(), getFlightMileage());
    }
}

