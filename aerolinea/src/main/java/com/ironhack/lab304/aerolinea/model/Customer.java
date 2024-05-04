package com.ironhack.lab304.aerolinea.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    private Integer totalCustomerMileage;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Customer(String johnDoe, String gold) {
    }

    // Getters and setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public String getName() {
        return customerName;
    }

    public String getStatus() {
        return customerStatus.toString(); //  customerStatus is an enum
    }

}
