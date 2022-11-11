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
        Parent root = FXMLLoader.load(getClass().getResource("PizzaType.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println(testVar);
    }

    public void switchToLogIn(ActionEvent event)  throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
