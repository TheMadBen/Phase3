package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Customer customer;

    @FXML
    private Text errorOutput;

    @FXML
    private TextField idField;

    @FXML
    private TextField emailField;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void switchToStatus(ActionEvent event)  throws IOException{
        //finalize order values to push

        //asurite validation occurs here
        boolean proceed = Store.asuriteValidation(idField.getText());


        //if invalid id, break from function
        if(!proceed) {
            //prompt user to try again
            errorOutput.setText("Asurite Verification Failed: Please \n enter a valid ASURITE ID.");
            return;
        }

        //pass user inputted values to customer object
        //input passed validation, change string into integer
        /******ADD THIS BACK ONCE VALIDATION IMPLEMENTED*******/
        //customer.setAsuId(Integer.valueOf(idField.getText()));

        customer.setEmail(emailField.getText());
        customer.getOrder().setStatus(Status.ACCEPTED);

        //calculate price
        customer.getOrder().setPrice(customer.getOrder().getCart().size()*Store.pricePerPizza);

        //order validated, push order to store Global Array
        Store.submittedOrders.add(customer.getOrder());
        Store.orders.add(customer.getOrder());

        //pass forward values to be used to send in status updates
        StatusController statusController = new StatusController();
        statusController.setCustomer(customer);

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Status.fxml"));
        loader.setController(statusController);

        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("Status.fxml"));
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
}
