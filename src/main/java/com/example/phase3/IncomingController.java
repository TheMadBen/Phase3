package com.example.phase3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IncomingController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView table;
    //private ScrollPane scroll;

    public void showCart(ActionEvent event) throws IOException {

        TableColumn<Order, String> column1 = new TableColumn<>("Order Number");
        column1.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    public void switchToAccept(ActionEvent event)  throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Accept.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        //System.out.println("THISS");

        //table = new TableView<Order>(FXCollections.observableList(Store.orders));

        TableColumn<Order, String> column1 = new TableColumn<>("Number of Pizzas");
        column1.setCellValueFactory(new PropertyValueFactory<>("numberOfPizzas"));

        TableColumn<Order, String> column2 = new TableColumn<>("Order Price");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Order, String> column3 = new TableColumn<>("Pickup Time");
        column3.setCellValueFactory(new PropertyValueFactory<>("pickupTime"));

        TableColumn<Order, String> column4 = new TableColumn<>("CheckBox");
        column4.setCellValueFactory(new PropertyValueFactory<>("checkBox"));

        table.getColumns().remove(0, 1);
        table.getColumns().remove(0, 1);

        table.getColumns().addAll(column1, column2, column3, column4);

        Order temp = new Order();
        Customer cus = new Customer();

        cus.setAsuId(1111);
        temp.setPrice(11.1);

        temp.setCustomer(cus);

        Store.orders.add(temp);

        Order temp1 = new Order();
        Customer cus1 = new Customer();

        cus1.setAsuId(1111);
        temp1.setPrice(11.1);

        temp.setCustomer(cus1);

        Store.orders.add(temp1);

        ObservableList<Order> orderList = FXCollections.observableList(Store.submittedOrders);

        for (Order order : orderList){
            table.getItems().add(order);
        }
       // scroll.getChildrenUnmodifiable().add(table);
    }

    public void acceptOrders(ActionEvent event)  throws IOException{
        Order temp = null;
        for (Order order : Store.submittedOrders) {
            if (order.getCheckBox().isSelected()) {
                temp = order;
            }
        }

        if(temp == null) return;

        Store.submittedOrders.remove(temp);
        Store.chefOrders.add(temp);
        temp.setStatus(Status.READY_TO_COOK);
        temp.getCheckBox().setSelected(false);
        table.getItems().remove(temp);
    }

    public void refresh(ActionEvent event) throws IOException {

        table.getItems().clear();

        for (Order order : Store.submittedOrders){
            table.getItems().add(order);
        }
    }
}
