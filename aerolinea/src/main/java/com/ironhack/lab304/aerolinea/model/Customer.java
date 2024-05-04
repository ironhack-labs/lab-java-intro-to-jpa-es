package com.ironhack.lab304.aerolinea.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String status;

    public Customer() {
        this.name = name;
        this.status = status;
    }

    public Customer(String johnDoe, String gold) {
    }

    // Getters and setters
    public Integer getId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Other getters and setters...
}