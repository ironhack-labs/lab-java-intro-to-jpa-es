package com.ironhack.lab_3_04.model;

import com.ironhack.lab_3_04.enums.CustomerStatus;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(columnDefinition = "ENUM('None', 'Silver', 'Gold')")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "total_customer_mileage")
    private int totalCustomerMileage;

    @OneToMany(mappedBy = "customer")
    List<FlightBooking> bookings;

    public Customer(){}

    public Customer(int customerId, String customerName, CustomerStatus customerStatus, int totalCustomerMileage, List<FlightBooking> bookings) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
        this.bookings = bookings;
    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
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
        Customer customer = (Customer) o;
        return customerId == customer.customerId && totalCustomerMileage == customer.totalCustomerMileage && Objects.equals(customerName, customer.customerName) && customerStatus == customer.customerStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerStatus, totalCustomerMileage);
    }
}

