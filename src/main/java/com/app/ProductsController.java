package com.app;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductsController {

    @FXML private TableView<Product> productsTable;
    @FXML private TableColumn<Product, String> nameCol;
    @FXML private TableColumn<Product, Double> priceCol;
    @FXML private TableColumn<Product, Integer> stockCol;

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        loadProducts();
    }

    private void loadProducts() {
        ObservableList<Product> products = DBHelper.getProducts();
        productsTable.setItems(products);
    }

    @FXML
    public void addProduct(ActionEvent event) {
        Product newProduct = new Product("New Product", 99.99, 10);   // You can change default values
        DBHelper.addProduct(newProduct);
        loadProducts();        // Refresh table
    }

    @FXML
    public void removeProduct(ActionEvent event) {
        Product selected = productsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            DBHelper.removeProduct(selected);
            loadProducts();
        } else {
            System.out.println("No product selected to remove.");
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws Exception {
        SceneManager.switchTo(event, "third.fxml");
    }
}