package com.example.flight_management;

import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private Integer customerId;
    private Integer flightId;

    public FlightBooking() {
    }

    public FlightBooking(Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    // Getters and setters omitted for brevity
}
