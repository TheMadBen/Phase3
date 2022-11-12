package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CartController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void switchToCheckout(ActionEvent event)  throws IOException{
        //pass values to be used in checkout
        CheckoutController checkout = new CheckoutController();
        checkout.setCustomer(customer);

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));
        loader.setController(checkout);

        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPizza(ActionEvent event)  throws IOException{

        //pass value of customer to continue order
        PizzaTypeController pizzaTypeController = new PizzaTypeController();
        pizzaTypeController.setCustomer(customer);

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaType.fxml"));
        loader.setController(pizzaTypeController);

        //load root using new loader
        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("PizzaType.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPickup(ActionEvent event)  throws IOException{
        //create controller for object passing
        PickupController pickup = new PickupController();
        pickup.setCustomer(customer); //pass customer to next window
        pickup.setPizza(customer.getOrder().getCart().get(customer.getOrder().getCart().size()-1));
        //pass pizza most recently added by accessing the last value of list
        //pizza will be added back to cart when this screen is reached again
        //remove pizza from cart temporarily to avoid duplication error
        pickup.setPizza(customer.getOrder().getCart().remove(customer.getOrder().getCart().size()-1));

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pickup.fxml"));
        loader.setController(pickup); //pass controller holding data to loader


        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PizzaType.fxml"));

        //load root using new loader
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("Pickup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
