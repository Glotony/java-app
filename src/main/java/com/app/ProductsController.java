package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductsController {

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<Product, String> nameCol;

    @FXML
    private TableColumn<Product, Double> priceCol;

    @FXML
    private TableColumn<Product, Integer> stockCol;

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // load products from DbHelper
        productsTable.setItems(ProductsDbHelper.getProducts());
    }

    @FXML
    public void addProduct(ActionEvent event) {
        Product newProduct = new Product("New Product", 0.0, 1);
        ProductsDbHelper.addProduct(newProduct);
        productsTable.refresh();
    }

    @FXML
    public void removeProduct(ActionEvent event) {
        Product selected = productsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ProductsDbHelper.removeProduct(selected);
            productsTable.refresh();
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws Exception {
        SceneManager.switchTo(event, "third.fxml");
    }
}
