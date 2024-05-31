package org.example.model;
import javax.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name="customerId",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="flightId",nullable = false)
    private Flight flight;
    public FlightBooking (){

    }
public FlightBooking(Customer customer,Flight flight){
        this.customer=customer;
        this.flight=flight;

}
public Integer getBookingId(){
        return bookingId;

}
public void setBookingId(Integer bookingId){
        this.bookingId=bookingId;

}
public Customer getCustomer(){
      return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public Flight getFlight(){
        return flight;
    }
    public void setflight(Flight flight){
        this.flight=flight;
    }
}
