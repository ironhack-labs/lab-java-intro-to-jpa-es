package org.example.week6labs.model;

import jakarta.persistence.*;
import org.example.week6labs.enums.CustomerStatus;

@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customerId;

  private String customerName;
  private CustomerStatus customerStatus;
  private Integer totalCustomerMileage;

  public Customer() {
  }

  public Customer(String customerName, CustomerStatus customer, Integer totalCustomerMileage) {
    this.customerName = customerName;
    this.customerStatus = customer;
    this.totalCustomerMileage = totalCustomerMileage;
  }

  public void setId(Integer id) {
    this.customerId = id;
  }

  public Integer getId() {
    return customerId;
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

  public void setCustomerStatus(CustomerStatus customer) {
    this.customerStatus = customer;
  }

  public Integer getTotalCustomerMileage() {
    return totalCustomerMileage;
  }

  public void setTotalCustomerMileage(Integer totalCustomerMileage) {
    this.totalCustomerMileage = totalCustomerMileage;
  }
}
