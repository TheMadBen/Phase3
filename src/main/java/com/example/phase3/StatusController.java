package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatusController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Customer customer;

    @FXML
    public Text statusField;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void switchToPizza(ActionEvent event)  throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void refreshStatus() {
        statusField.setText(customer.getOrder().getStatus().name());
    }
}
