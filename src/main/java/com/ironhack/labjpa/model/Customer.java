package com.ironhack.labjpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "CustomerName", nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "totalCustomerMileage", nullable = false)
    private int totalCustomerMileage;

    public Customer() {
    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setName(String name) {
        this.customerName = customerName;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public int getCustomerId() {
        return customerId;
    }
}

