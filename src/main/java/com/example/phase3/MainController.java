package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import static com.example.phase3.Store.testVar;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToPizza(ActionEvent event)  throws IOException{
        //SEND NECESSARY DATA TO NEW PAGE
        testVar++;

        //user navigates to customer facing interface
        //create customer object and order object for customer to hold
        Customer customer = new Customer();
        Order order = new Order();

        //create 1 to 1 relationship
        customer.setOrder(order);
        order.setCustomer(customer);

        //create controller for object passing
        PizzaTypeController pizzaTypeController = new PizzaTypeController();
        pizzaTypeController.setCustomer(customer); //pass customer to next window

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaType.fxml"));
        loader.setController(pizzaTypeController); //pass controller holding data to loader


        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PizzaType.fxml"));

        //load root using new loader
        Parent root = loader.load();

        //root.setController(pizzaTypeController);
       // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage = new Stage();
        stage.close();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //System.out.println(testVar);
    }

    public void switchToLogIn(ActionEvent event)  throws IOException{
        //FXMLLoader loader = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));

        //FXMLLoader loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //loader.

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

        Parent root = loader.load();

        //previous implementation used if no information is passed (USE BOTTOM IN THIS CASE POTENTIALLY)
        //while no info is actually passed in the above configuration, allows for future implementation
        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        //removing this statement allows for new window to be created for testing
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        //NEW STAGE = NEW WINDOW FOR DEBUGGING
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
