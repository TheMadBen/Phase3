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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CartController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Customer customer;

    @FXML
    private TableView pizzaDisplay;

    @FXML
    private Text priceField;
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void removePizza(ActionEvent event) throws IOException {
        //find selected pizza and remove
        Pizza toDelete = null;

        for (Pizza pizza: customer.getOrder().getCart()) {
            if(pizza.getCheckBox().isSelected()) {
                toDelete = pizza;
            }
        }

        customer.getOrder().getCart().remove(toDelete);

        customer.getOrder().setNumberOfPizzas(customer.getOrder().getNumberOfPizzas()-1);

        setTable(new ActionEvent());

    }

    public void editPizza(ActionEvent event) throws IOException {
        //find selected pizza and remove
        Pizza toDelete = null;

        for (Pizza pizza: customer.getOrder().getCart()) {
            if(pizza.getCheckBox().isSelected()) {
                toDelete = pizza;
            }
        }

        if(toDelete == null) return;

        customer.getOrder().setNumberOfPizzas(customer.getOrder().getNumberOfPizzas()-1);

        customer.getOrder().getCart().remove(toDelete);
        setTable(new ActionEvent());

        switchToPizza(event);
    }


    public void setTable(ActionEvent event) throws IOException{
        TableColumn<Pizza, String> column1 = new TableColumn<>("Pizza ingredients");
        column1.setCellValueFactory(new PropertyValueFactory<>("output"));

        TableColumn<Pizza, String> column2 = new TableColumn<>("CheckBox");
        column2.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        //column2.setCellValueFactory(new

        pizzaDisplay.getItems().clear();
        pizzaDisplay.getColumns().clear();

        pizzaDisplay.getColumns().addAll(column1, column2);

        for (Pizza pizza: customer.getOrder().getCart()) {
            pizza.setOutput(pizza.pizzaToString());
            pizzaDisplay.getItems().add(pizza);
            //pizzaDisplay.getItems().
        }

        priceField.setText(String.format("$%.2f", customer.getOrder().getPrice()));
    }
    public void switchToCheckout(ActionEvent event)  throws IOException{
        //pass values to be used in checkout
        PickupController pickup = new PickupController();
        pickup.setCustomer(customer);

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pickup.fxml"));
        loader.setController(pickup);

        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
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

    public void switchToPickup(ActionEvent event)  throws IOException{
        //create controller for object passing
        PickupController pickup = new PickupController();
        pickup.setCustomer(customer); //pass customer to next window
        //pickup.setPizza(customer.getOrder().getCart().get(customer.getOrder().getCart().size()-1));
        //pass pizza most recently added by accessing the last value of list
        //pizza will be added back to cart when this screen is reached again
        //remove pizza from cart temporarily to avoid duplication error
        //pickup.setPizza(customer.getOrder().getCart().remove(customer.getOrder().getCart().size()-1));

        //create loader to move data
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pickup.fxml"));
        loader.setController(pickup); //pass controller holding data to loader


        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PizzaType.fxml"));

        //load root using new loader
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("Pickup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public CartController(ActionEvent event, Customer customer) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "cart.fxml"));
        //fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.setCustomer(customer);
        Parent root = fxmlLoader.load();
        try {
            //load root using new loader
            //Parent root = fxmlLoader.load();
            setTable(new ActionEvent());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

       /* //load root using new loader
        Parent root = fxmlLoader.load();*/

        //Parent root = FXMLLoader.load(getClass().getResource("Pickup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
