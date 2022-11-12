package com.example.phase3;

/**
 *
 * @author gupta
 */
public class Customer {

    //attributes of Customer class
    int asuId;
    String email;
    Order order;

    // Create a class constructor for the Customer class
    public Customer(int asuId, String email, Order order) {
        //initializes variables 
        asuId = this.asuId;
        email = this.email;
        order = this.order;
    }

    public Customer() {

    }

    public int getAsuId() {
        return asuId;
    }

    public void setAsuId(int asuId) {
        this.asuId = asuId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void createOrder() {
    }

    public Status checkStatus(int orderNum) {
        //return status

        return order.getStatus();
    }

    public void placeOrder() {
    }

}
