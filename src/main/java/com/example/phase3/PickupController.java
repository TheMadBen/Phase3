package com.example.phase3;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class PickupController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox timeBox;
    @FXML
    private Text errorTime;
    boolean cont = false;
    ObservableList<String> time = FXCollections.observableArrayList("00:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00");
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
            errorTime.setText("Please Select a Valid Pickup Time");
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
        boolean currTime = true;

        Object temp = timeBox.getValue();
        String selected = temp.toString();
        customer.getOrder().setPickupTime(selected);

        int cTime = timeToInt(currentTime(), currTime);
        currTime = false;
        int sTime = timeToInt(customer.getOrder().getPickupTime(), currTime);

        if(sTime - cTime > 45) {
            cont = true;
        }
        else {
            cont = false;
        }
    }
    public String currentTime() {
        //for 12 hour time do: "h:mm a"
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hhmm"); //in military time
        LocalDateTime now = LocalDateTime.now();
        return timeFormat.format(now);
    }

    public int timeToInt(String time, boolean currTime) {
        int timeInt;
        String temp = "";

        if(!currTime) { //this is for the case where i need to convert the selected time to int
            String s[] = time.split(":");
            for(String w:s) {
                temp += w;
            }
            timeInt = Integer.parseInt(temp);
        }
        else { //this is where i need to convert current time to int
            timeInt = Integer.parseInt(time);
        }

        return timeInt;
    }
}
