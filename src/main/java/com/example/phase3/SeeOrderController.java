package com.example.phase3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SeeOrderController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToAccept(ActionEvent event)  throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Accept.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
