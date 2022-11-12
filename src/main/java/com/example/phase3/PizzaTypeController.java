package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class PizzaTypeController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public Pizza pizza = new Pizza();
    public Customer customer;


    @FXML
    private CheckBox pepCheck;
    @FXML
    private CheckBox vegCheck;
    @FXML
    private CheckBox cheeseCheck;
    public void pepperoni(ActionEvent event) {
        if(pepCheck.isSelected()) {
            pizza.setPepperoni(true);
            System.out.println(pizza.isPepperoni());
        }
        else {
            pizza.setPepperoni(false);
            System.out.println(pizza.isPepperoni());
        }
    }
    public void vegetable(ActionEvent event) {
        if(vegCheck.isSelected()) {
            pizza.setVegetables(true);
            System.out.println(pizza.isVegetables());
        }
        else {
            pizza.setVegetables(false);
            System.out.println(pizza.isVegetables());
        }
    }
    public void cheese(ActionEvent event) {
        if(cheeseCheck.isSelected()) {
            pizza.setCheese(true);
            System.out.println(pizza.isCheese());
        }
        else {
            pizza.setCheese(false);
            System.out.println(pizza.isCheese());
        }
    }

    //set customer to pass objects through windows
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void switchToToppings(ActionEvent event)  throws IOException{

        //customer.getOrder().getCart().add(pizza);

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
        stage.close();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToMain(ActionEvent event)  throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
