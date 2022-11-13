package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SeeOrderController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Order order;

    @FXML
    private TableView table;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setTable(Scene scene) {

        TableColumn<String, String> column1 = new TableColumn<>("Pizza");

        //scene.getRoot().add(table);

        System.out.println("Table Set");
        for (Pizza pizza : order.getCart()) {
            System.out.println("Ran");
            table.getItems().add(pizza.pizzaToString());
        }
    }

    public void switchToAccept(ActionEvent event)  throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Accept.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
