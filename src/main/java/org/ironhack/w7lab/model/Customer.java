package org.ironhack.w7lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status")
    private CustomerStatus customerStatus;

    @Column(name = "total_customer_mileage")
    private Integer totalCustomerMileage;

    public Customer() {

    }

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

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

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getTotalCustomerMileage() == customer.getTotalCustomerMileage() &&
                Objects.equals(customerId, customer.customerId) && Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getCustomerStatus(), customer.getCustomerStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, getCustomerName(), getCustomerStatus(), getTotalCustomerMileage());
    }
}