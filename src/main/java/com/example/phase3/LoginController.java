package com.example.phase3;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Text errMsg;
    @FXML
    private Text errMsg1;

    public void switchToIncoming(ActionEvent event)  throws IOException{

       if(!(userField.getText().contains("@") && userField.getText().contains(".")) && passField.getText().isEmpty()) {
               errMsg.setText("Please Enter a Valid Email");
               errMsg1.setText("Please Enter Password");
               return;
       }
       else if(!(userField.getText().contains("@") && userField.getText().contains("."))) {
           errMsg.setText("Please Enter a Valid Email");
           errMsg1.setText("");
           return;
       }
       else if(passField.getText().isEmpty()) {
           errMsg.setText("");
           errMsg1.setText("Please Enter Password");
           return;
       }

        Parent root = FXMLLoader.load(getClass().getResource("Incoming.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
