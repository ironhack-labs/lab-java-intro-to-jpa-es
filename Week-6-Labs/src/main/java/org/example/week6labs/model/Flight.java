package org.example.week6labs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer flightId;
  private String flightNumber;
  private String aircarft;
  private Integer totalAircarftSeats;
  private Integer flightMileage;

  public Flight() {
  }

  public Flight(String flightNumber, String aircarft, Integer totalAircarftSeats, Integer flightMileage) {
    this.flightNumber = flightNumber;
    this.aircarft = aircarft;
    this.totalAircarftSeats = totalAircarftSeats;
    this.flightMileage = flightMileage;
  }

  public void setId(Integer id) {
    this.flightId = id;
  }

  public Integer getId() {
    return flightId;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getAircarft() {
    return aircarft;
  }

  public void setAircarft(String aircarft) {
    this.aircarft = aircarft;
  }

  public Integer getTotalAircarftSeats() {
    return totalAircarftSeats;
  }

  public void setTotalAircarftSeats(Integer totalAircarftSeats) {
    this.totalAircarftSeats = totalAircarftSeats;
  }

  public Integer getFlightMileage() {
    return flightMileage;
  }

  public void setFlightMileage(Integer flightMileage) {
    this.flightMileage = flightMileage;
  }
}
