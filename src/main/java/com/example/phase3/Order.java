package com.example.phase3;
import javafx.scene.control.CheckBox;

import java.util.*;
/**
 *
 * @author gupta
 */
// Create an Order class
public class Order {
    //attributes of Order class

    String pickupTime;

    ArrayList<Pizza> cart = new ArrayList<>();
    //Pizza[] cart;
    double price;
    Status status;
    Customer customer;

    CheckBox checkBox = new CheckBox();

    // Create a class constructor for the Order class
    public Order(/*Date pickupTime,*/ ArrayList<Pizza> cart, double price, Status status, Customer customer) {
        //initializes variables 
        //this.pickupTime = pickupTime;
        this.cart = cart;
        this.price = price;
        this.status = status;
        this.customer = customer;
    }

    public Order() {
    //cart = null;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public ArrayList<Pizza> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Pizza> cart) {
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

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
