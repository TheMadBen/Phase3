package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class PickupController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Customer customer;
    public Pizza pizza;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void switchToCart(ActionEvent event)  throws IOException{
        //be sure to change pizza pickup time here

        //once this step is reached, pizza should THEN be added to order
        if(pizza != null) {
            customer.getOrder().getCart().add(pizza);
        }

        //now, only customer need be passed moving forward
        CartController cart = new CartController();
        cart.setCustomer(customer); //pass customer to next window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
        loader.setController(cart); //pass controller holding data to loader

        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToToppings(ActionEvent event)  throws IOException{
        ToppingsController toppings = new ToppingsController();
        toppings.setCustomer(customer);
        toppings.setPizza(pizza);

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Toppings.fxml"));
        loader.setController(toppings); //pass controller holding data to loader

        //load root using new loader
        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("Toppings.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
