package com.example.phase3;
import java.util.*;
/**
 *
 * @author gupta
 */
// Create a Order class
public class Order {
    //attributes of Order class

    Date pickupTime;
    Pizza[] cart;
    double price;
    Status status;
    Customer customer;

    // Create a class constructor for the Order class
    public Order(Date pickupTime, Pizza[] cart, double price, Status status, Customer customer) {
        //initializes variables 
        pickupTime = this.pickupTime;
        cart = this.cart;
        price = this.price;
        status = this.status;
        customer = this.customer;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Pizza[] getCart() {
        return cart;
    }

    public void setCart(Pizza[] cart) {
        this.cart = cart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
