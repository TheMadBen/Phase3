package com.example.phase3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PickupController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox timeBox;
    @FXML
    private Text errorTime;
    boolean cont = false;
    ObservableList<String> time = FXCollections.observableArrayList("0000", "0100", "0200", "0300", "0400", "0500", "0600", "0700", "0800", "0900", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300");
    public Customer customer;
    //public Pizza pizza;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

/*    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }*/

    public void switchToCart(ActionEvent event)  throws IOException{
        //be sure to change pizza pickup time here

        //once this step is reached, pizza should THEN be added to order
      /*  if(pizza != null) {
            System.out.println("pizza added to cart");
            customer.getOrder().getCart().add(pizza);
            customer.getOrder().setNumberOfPizzas(customer.getOrder().getNumberOfPizzas()+1);
        }*/
        if(!cont) {
            errorTime.setText("Please select a pickup time");
            return;
        }

        //now, only customer need be passed moving forward
        CheckoutController checkout = new CheckoutController();
        checkout.setCustomer(customer); //pass customer to next window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));
        loader.setController(checkout); //pass controller holding data to loader

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
        //toppings.setPizza(pizza);

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

    @FXML
    public void initialize() {
        timeBox.getItems().removeAll(timeBox.getItems());
        timeBox.getItems().addAll(time);
    }
    public void seeTime(ActionEvent event) {
        Object temp = timeBox.getValue();
        String selected = temp.toString();
        customer.getOrder().setPickupTime(selected);
        System.out.println(customer.getOrder().getPickupTime());
        cont = true;
    }
}
