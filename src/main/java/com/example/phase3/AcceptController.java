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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AcceptController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Order orderCur = null;

    @FXML
    private TableView table;

    @FXML
    private Button viewOrderButton;

    @FXML
    private Button setToCook;

    @FXML
    private TextArea orderDisplay;


    public void switchToSeeOrder(ActionEvent event)  throws IOException{
        for (Order order : Store.chefOrders) {
            if (order.getCheckBox().isSelected()) {
                orderCur = order;
            }
        }

        if (orderCur == null) {
            //output "please select an order"
            //break function
            return;
        }

        String outputOrder = "";
        System.out.println("Table Set");
        for (Pizza pizza : orderCur.getCart()) {
            outputOrder += pizza.pizzaToString();
            //table.getItems().add(pizza.pizzaToString());
        }

        orderDisplay.setText(outputOrder);


        //pass forward values to be used to send in status updates
    /*    SeeOrderController statusController = new SeeOrderController();
        statusController.setOrder(orderCur);




        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeeOrder.fxml"));
        loader.setController(statusController);

        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("SeeOrder.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        statusController.setTable(scene);
        stage.show();*/
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

        ObservableList<Order> orderList = FXCollections.observableList(Store.chefOrders);

        for (Order order : orderList){
            table.getItems().add(order);
        }
        // scroll.getChildrenUnmodifiable().add(table);
    }

    public void setSetToCook(ActionEvent event)  throws IOException{
        for (Order order : Store.chefOrders) {
            if (order.getCheckBox().isSelected()) {
                Store.chefOrders.remove(order);
                //Store.chefOrders.add(order);
                table.getItems().remove(order);
            }
        }
    }

    public void refresh(ActionEvent event) throws IOException {

        table.getItems().clear();

        for (Order order : Store.chefOrders){
            table.getItems().add(order);
        }
    }

    public void setCook(ActionEvent event) throws IOException {

    }
}
