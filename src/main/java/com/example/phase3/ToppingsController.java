package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class ToppingsController {
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

    @FXML
    private CheckBox mushroomCheck;
    @FXML
    private CheckBox onionCheck;
    @FXML
    private CheckBox olivesCheck;
    @FXML
    private CheckBox extraCheeseCheck;

    public void mushroom(ActionEvent event) {
        if(mushroomCheck.isSelected()) {
            pizza.setMushroom(true);
            //System.out.println(pizza.isPepperoni());
        }
        else {
            pizza.setMushroom(false);
            //System.out.println(pizza.isPepperoni());
        }
    }

    public void onion(ActionEvent event) {
        if(onionCheck.isSelected()) {
            pizza.setOnion(true);
            //System.out.println(pizza.isPepperoni());
        }
        else {
            pizza.setOnion(false);
            //System.out.println(pizza.isPepperoni());
        }
    }

    public void olives(ActionEvent event) {
        if(olivesCheck.isSelected()) {
            pizza.setOlives(true);
            //System.out.println(pizza.isPepperoni());
        }
        else {
            pizza.setOlives(false);
            //System.out.println(pizza.isPepperoni());
        }
    }

    public void extraCheese(ActionEvent event) {
        if(extraCheeseCheck.isSelected()) {
            pizza.setExtraCheese(true);
            //System.out.println(pizza.isPepperoni());
        }
        else {
            pizza.setExtraCheese(false);
            //System.out.println(pizza.isPepperoni());
        }
    }
    public void switchToPizza(ActionEvent event)  throws IOException{
        //create controller for object passing
        PizzaTypeController pizzaTypeController = new PizzaTypeController();
        pizzaTypeController.setCustomer(customer); //pass customer to next window

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaType.fxml"));
        loader.setController(pizzaTypeController); //pass controller holding data to loader


        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PizzaType.fxml"));

        //load root using new loader
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("PizzaType.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPickup(ActionEvent event)  throws IOException{
        //add pizza to order
        //customer.getOrder().getCart().add(pizza);
        if(pizza != null) {
            //System.out.println("pizza added to cart");
            customer.getOrder().getCart().add(pizza);
            customer.getOrder().setNumberOfPizzas(customer.getOrder().getNumberOfPizzas()+1);
        }


        //create controller for object passing
        CartController cart = new CartController(event, customer);
        //cart.setCustomer(customer); //pass customer to next window
        // pickup.setPizza(pizza); //pass pizza to next window


  /*      //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
        loader.setController(cart); //pass controller holding data to loader
        //cart.setTable(event);
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PizzaType.fxml"));
        //load root using new loader
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("Pickup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
    }
}